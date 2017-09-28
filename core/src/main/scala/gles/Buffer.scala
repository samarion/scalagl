package gles

object Buffer {
  object Type extends Enumeration {
    type Type = Value
    val BOOLEAN, BYTE, SHORT, INT, FLOAT, LONG, DOUBLE = Value
  }

  sealed abstract class BufferType[@specialized(Boolean, Byte, Short, Int, Float, Long, Double) T](val id: Type)
  case object BooleanType extends Type[Boolean](Type.BOOLEAN)
  case object ByteType extends Type[Byte](Type.BYTE)
  case object ShortType extends Type[Short](Type.SHORT)
  case object IntType extends Type[Int](Type.INT)
  case object FloatType extends Type[Float](Type.FLOAT)
  case object LongType extends Type[Long](Type.LONG)
  case object DoubleType extends Type[Double](Type.DOUBLE)
}

abstract class Buffer[@specialized(Boolean, Byte, Short, Int, Float, Long, Double) T](
  final val data: Array[T],
  final val start: Int,
  final val end: Int,
  final val tpe: Buffer.BufferType[T]) {

  def this(size: Int) = this(0, size, new Array[T](size))

  final val size = end - start

  @inline
  final def apply(i: Int): T = get(i)

  final def get(i: Int): T = data(i + start)
  final def update(i: Int, value: T): Unit = data(i + start) = value

  @inline
  final def as[@specialized(Boolean, Byte, Short, Int, Float, Long, Double) U]
              (asTpe: Buffer.BufferType[U]): Buffer[U] = {
    assert(tpe eq asTpe, "Trying to cast buffer of type " + tpe + " to type " + asTpe)
    this.asInstanceOf[Buffer[U]]
  }

  final lazy val nioBuffer: java.nio.Buffer = (tpe.id: @switch) match {
    case Buffer.Type.BYTE => java.nio.ByteBuffer.wrap(data.asInstanceOf[Array[Byte]], start, size)
    case Buffer.Type.SHORT => java.nio.ShortBuffer.wrap(data.asInstanceOf[Array[Short]], start, size)
    case Buffer.Type.INT => java.nio.IntBuffer.wrap(data.asInstanceOf[Array[Int]], start, size)
    case Buffer.Type.FLOAT => java.nio.FloatBuffer.wrap(data.asInstanceOf[Array[Float]], start, size)
    case Buffer.Type.LONG => java.nio.LongBuffer.wrap(data.asInstanceOf[Array[Long]], start, size)
    case Buffer.Type.DOUBLE => java.nio.DoubleBuffer.wrap(data.asInstanceOf[Array[Double]], start, size)
    case tpe => throw new RuntimeException("Can't translate buffer of type " + tpe + " to java.nio.Buffer")
  }
}
