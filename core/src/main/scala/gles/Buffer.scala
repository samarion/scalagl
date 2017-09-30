package gles

import scala.reflect._
import scala.annotation.switch

object Buffer {
  type PrimitiveType = Int
  final object PrimitiveTypes {
    final val BOOLEAN = 0
    final val BYTE    = 1
    final val SHORT   = 2
    final val INT     = 3
    final val FLOAT   = 4
    final val LONG    = 5
    final val DOUBLE  = 6
  }
  import PrimitiveTypes._

  sealed abstract class BufferType[@specialized(Boolean, Byte, Short, Int, Float, Long, Double) T : ClassTag](val primitive: PrimitiveType) {
    val tag = classTag[T]
  }

  implicit case object BooleanType extends BufferType[Boolean](BOOLEAN)
  implicit case object ByteType extends BufferType[Byte](BYTE)
  implicit case object ShortType extends BufferType[Short](SHORT)
  implicit case object IntType extends BufferType[Int](INT)
  implicit case object FloatType extends BufferType[Float](FLOAT)
  implicit case object LongType extends BufferType[Long](LONG)
  implicit case object DoubleType extends BufferType[Double](DOUBLE)
}

import Buffer._
import PrimitiveTypes._

abstract class Buffer[@specialized(Boolean, Byte, Short, Int, Float, Long, Double) T : BufferType](
  final val data: Array[T],
  final val start: Int,
  final val end: Int) {

  private[this] val tpe = implicitly[BufferType[T]]

  def this(size: Int) = this(Array.ofDim[T](size)(implicitly[BufferType[T]].tag), 0, size)

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

  def titi(a: Int) = {
    (a: @switch) match {
      case BOOLEAN =>
      case 2 =>
      case 3 =>
    }
  }

  final lazy val nioBuffer: java.nio.Buffer = (tpe.primitive: @switch) match {
    case BYTE => java.nio.ByteBuffer.wrap(data.asInstanceOf[Array[Byte]], start, size)
    case SHORT => java.nio.ShortBuffer.wrap(data.asInstanceOf[Array[Short]], start, size)
    case INT => java.nio.IntBuffer.wrap(data.asInstanceOf[Array[Int]], start, size)
    case FLOAT => java.nio.FloatBuffer.wrap(data.asInstanceOf[Array[Float]], start, size)
    case LONG => java.nio.LongBuffer.wrap(data.asInstanceOf[Array[Long]], start, size)
    case DOUBLE => java.nio.DoubleBuffer.wrap(data.asInstanceOf[Array[Double]], start, size)
    case _ => throw new RuntimeException("Can't translate buffer of type " + tpe + " to java.nio.Buffer")
  }
}
