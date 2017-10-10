package scalagl.gl

import scala.reflect._

import scala.annotation.switch

import scala.language.implicitConversions

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

  sealed abstract class BufferType[@specialized(Boolean, Byte, Short, Int, Float, Long, Double) T : ClassTag]
                                  (val primitive: PrimitiveType) {
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

object JavaNioConversions {

  sealed abstract class NioConverter[T] {
    type Result <: java.nio.Buffer
    def convert(buffer: Buffer[T]): Result
  }

  implicit case object ByteConverter extends NioConverter[Byte] {
    final type Result = java.nio.ByteBuffer
    final def convert(buffer: Buffer[Byte]): java.nio.ByteBuffer =
      java.nio.ByteBuffer.wrap(buffer.data, buffer.start, buffer.size)
  }
  implicit final def toNioByteBuffer(buffer: Buffer[Byte]): java.nio.ByteBuffer = buffer.nioBufferSpecialized

  implicit case object ShortConverter extends NioConverter[Short] {
    final type Result = java.nio.ShortBuffer
    final def convert(buffer: Buffer[Short]): java.nio.ShortBuffer =
      java.nio.ShortBuffer.wrap(buffer.data, buffer.start, buffer.size)
  }
  implicit final def toNioShortBuffer(buffer: Buffer[Short]): java.nio.ShortBuffer = buffer.nioBufferSpecialized

  implicit case object IntConverter extends NioConverter[Int] {
    final type Result = java.nio.IntBuffer
    final def convert(buffer: Buffer[Int]): java.nio.IntBuffer =
      java.nio.IntBuffer.wrap(buffer.data, buffer.start, buffer.size)
  }
  implicit final def toNioIntBuffer(buffer: Buffer[Int]): java.nio.IntBuffer = buffer.nioBufferSpecialized

  implicit case object FloatConverter extends NioConverter[Float] {
    final type Result = java.nio.FloatBuffer
    final def convert(buffer: Buffer[Float]): java.nio.FloatBuffer =
      java.nio.FloatBuffer.wrap(buffer.data, buffer.start, buffer.size)
  }
  implicit final def toNioFloatBuffer(buffer: Buffer[Float]): java.nio.FloatBuffer = buffer.nioBufferSpecialized

  implicit case object LongConverter extends NioConverter[Long] {
    final type Result = java.nio.LongBuffer
    final def convert(buffer: Buffer[Long]): java.nio.LongBuffer =
      java.nio.LongBuffer.wrap(buffer.data, buffer.start, buffer.size)
  }
  implicit final def toNioLongBuffer(buffer: Buffer[Long]): java.nio.LongBuffer = buffer.nioBufferSpecialized

  implicit case object DoubleConverter extends NioConverter[Double] {
    final type Result = java.nio.DoubleBuffer
    final def convert(buffer: Buffer[Double]): java.nio.DoubleBuffer =
      java.nio.DoubleBuffer.wrap(buffer.data, buffer.start, buffer.size)
  }
  implicit final def toNioDoubleBuffer(buffer: Buffer[Double]): java.nio.DoubleBuffer = buffer.nioBufferSpecialized

  implicit final def toNioBuffer(buffer: Buffer[_]): java.nio.Buffer = buffer.nioBuffer
}

final class Buffer[@specialized(Boolean, Byte, Short, Int, Float, Long, Double) T : BufferType](
  final val data: Array[T],
  final val start: Int,
  final val end: Int) {

  def this(size: Int) = this(Array.ofDim[T](size)(implicitly[BufferType[T]].tag), 0, size)

  final val tpe = implicitly[BufferType[T]]
  final val size = end - start

  @inline
  final def apply(i: Int): T = get(i)

  final def get(i: Int): T = data(i + start)
  final def update(i: Int, value: T): Unit = data(i + start) = value

  @inline
  final def slice(end: Int): Buffer[T] = slice(0, end)
  final def slice(start: Int, end: Int): Buffer[T] = {
    assert(start > 0 && end < size, "Trying to slice outside of buffer bounds")
    new Buffer(data, this.start + start, this.start + end)
  }

  @inline
  final def as[@specialized(Boolean, Byte, Short, Int, Float, Long, Double) U]
              (implicit asTpe: BufferType[U]): Buffer[U] = {
    assert(tpe eq asTpe, "Trying to cast buffer of type " + tpe + " to type " + asTpe)
    this.asInstanceOf[Buffer[U]]
  }

  private[this] var _nioBuffer: java.nio.Buffer = null

  import JavaNioConversions._
  private[gl] final def nioBufferSpecialized(implicit c: NioConverter[T]): c.Result = {
    if (_nioBuffer eq null) _nioBuffer = c.convert(this)
    _nioBuffer.asInstanceOf[c.Result]
  }

  private[gl] final def nioBuffer: java.nio.Buffer = {
    if (_nioBuffer eq null) {
      (tpe.primitive: @switch) match {
        case BYTE => as[Byte].nioBufferSpecialized
        case SHORT => as[Short].nioBufferSpecialized
        case INT => as[Int].nioBufferSpecialized
        case FLOAT => as[Float].nioBufferSpecialized
        case LONG => as[Long].nioBufferSpecialized
        case DOUBLE => as[Double].nioBufferSpecialized
        case _ => throw new RuntimeException("Can't translate buffer of type " + tpe + " to java.nio.Buffer")
      }
    } else {
      _nioBuffer
    }
  }
}
