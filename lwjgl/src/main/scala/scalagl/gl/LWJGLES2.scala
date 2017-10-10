package scalagl.gl

import scala.annotation.switch
import org.lwjgl.opengles._

import Buffer._
import JavaNioConversions._

class LWJGLES2 extends GLES2 {
  private[this] val ib1 = java.nio.IntBuffer.allocate(10)
  private[this] val ib2 = java.nio.IntBuffer.allocate(10)

  def glActiveTexture(texture: Int): Unit = {
    GLES20.glActiveTexture(texture)
  }

  def glAttachShader(program: Int, shader: Int): Unit = {
    GLES20.glAttachShader(program, shader)
  }

  def glBindAttribLocation(program: Int, index: Int, name: String): Unit = {
    GLES20.glBindAttribLocation(program, index, name)
  }

  def glBindBuffer(target: Int, buffer: Int): Unit = {
    GLES20.glBindBuffer(target, buffer)
  }

  def glBindFramebuffer(target: Int, buffer: Int): Unit = {
    GLES20.glBindFramebuffer(target, buffer)
  }

  def glBindRenderbuffer(target: Int, buffer: Int): Unit = {
    GLES20.glBindRenderbuffer(target, buffer)
  }

  def glBindTexture(target: Int, texture: Int): Unit = {
    GLES20.glBindTexture(target, texture)
  }

  def glBlendColor(red: Float, green: Float, blue: Float, alpha: Float): Unit = {
    GLES20.glBlendColor(red, green, blue, alpha)
  }

  def glBlendEquation(mode: Int): Unit = {
    GLES20.glBlendEquation(mode)
  }

  def glBlendEquationSeparate(rgb: Int, alpha: Int): Unit = {
    GLES20.glBlendEquationSeparate(rgb, alpha)
  }

  def glBlendFunc(sfactor: Int, dfactor: Int): Unit = {
    GLES20.glBlendFunc(sfactor, dfactor)
  }

  def glBlendFuncSeparate(rgbSrc: Int, rgbDst: Int, alphaSrc: Int, alphaDst: Int): Unit = {
    GLES20.glBlendFuncSeparate(rgbSrc, rgbDst, alphaSrc, alphaDst)
  }

  def glBufferData(target: Int, size: Long, usage: Int): Unit = {
    GLES20.glBufferData(target, size, usage)
  }

  def glBufferData(target: Int, data: Buffer[_], usage: Int): Unit = (data.tpe.primitive: @switch) match {
    case Buffer.PrimitiveTypes.BYTE => GLES20.glBufferData(target, data.as[Byte], usage)
    case Buffer.PrimitiveTypes.SHORT => GLES20.glBufferData(target, data.as[Short], usage)
    case Buffer.PrimitiveTypes.INT => GLES20.glBufferData(target, data.as[Int], usage)
    case Buffer.PrimitiveTypes.FLOAT => GLES20.glBufferData(target, data.as[Float], usage)
  }

  def glBufferSubData(target: Int, offset: Long, data: Buffer[_]): Unit = (data.tpe.primitive: @switch) match {
    case Buffer.PrimitiveTypes.BYTE => GLES20.glBufferSubData(target, offset, data.as[Byte])
    case Buffer.PrimitiveTypes.SHORT => GLES20.glBufferSubData(target, offset, data.as[Short])
    case Buffer.PrimitiveTypes.INT => GLES20.glBufferSubData(target, offset, data.as[Int])
    case Buffer.PrimitiveTypes.FLOAT => GLES20.glBufferSubData(target, offset, data.as[Float])
  }

  def glCheckFramebufferStatus(target: Int): Int = {
    GLES20.glCheckFramebufferStatus(target)
  }

  def glClear(mask: Int): Unit = {
    GLES20.glClear(mask)
  }

  def glClearColor(red: Float, green: Float, blue: Float, alpha: Float): Unit = {
    GLES20.glClearColor(red, green, blue, alpha)
  }

  def glClearDepth(depth: Float): Unit = {
    GLES20.glClearDepthf(depth)
  }

  def glClearStencil(s: Int): Unit = {
    GLES20.glClearStencil(s)
  }

  def glColorMask(red: Boolean, green: Boolean, blue: Boolean, alpha: Boolean): Unit = {
    GLES20.glColorMask(red, green, blue, alpha)
  }

  def glCompileShader(shader: Int): Unit = {
    GLES20.glCompileShader(shader)
  }

  def glCompressedTexImage2D(target: Int, level: Int, format: Int,
    width: Int, height: Int, border: Int, imageSize: Int, pointer: Long): Unit = {
      GLES20.glCompressedTexImage2D(target, level, format, width, height, border, imageSize, pointer)
  }

  def glCompressedTexImage2D(target: Int, level: Int, format: Int,
    width: Int, height: Int, border: Int, imageSize: Int, data: Buffer[_]): Unit = {
      GLES20.glCompressedTexImage2D(target, level, format, width, height, border, data.as[Byte].slice(imageSize))
    }

  def glCompressedTexSubImage2D(target: Int, level: Int, xoffset: Int, yoffset: Int,
    width: Int, height: Int, format: Int, imageSize: Int, pointer: Long): Unit = {
      GLES20.glCompressedTexSubImage2D(target, level, xoffset, yoffset, width, height, format, imageSize, pointer)
  }

  def glCompressedTexSubImage2D(target: Int, level: Int, xoffset: Int, yoffset: Int,
    width: Int, height: Int, format: Int, imageSize: Int, data: Buffer[_]): Unit = {
      GLES20.glCompressedTexSubImage2D(target, level, xoffset, yoffset, width, height, format, data.as[Byte].slice(imageSize))
  }

  def glCopyTexImage2D(target: Int, level: Int, format: Int, x: Int, y: Int,
    width: Int, height: Int, border: Int): Unit = {
      GLES20.glCopyTexImage2D(target, level, format, x, y, width, height, border)
  }

  def glCopyTexSubImage2D(target: Int, level: Int, xoffset: Int, yoffset: Int, x: Int, y: Int,
    width: Int, height: Int): Unit = {
      GLES20.glCopyTexSubImage2D(target, level, xoffset, yoffset, x, y, width, height)
  }

  def glCreateProgram(): Int = {
    GLES20.glCreateProgram()
  }

  def glCreateShader(shaderType: Int): Int = {
    GLES20.glCreateShader(shaderType)
  }

  def glCullFace(mode: Int): Unit = {
    GLES20.glCullFace(mode)
  }

  def glDeleteBuffers(buffers: Buffer[Int]): Unit = {
    GLES20.glDeleteBuffers(buffers)
  }

  def glDeleteFramebuffers(buffers: Buffer[Int]): Unit = {
    GLES20.glDeleteFramebuffers(buffers)
  }

  def glDeleteProgram(program: Int): Unit = {
    GLES20.glDeleteProgram(program)
  }

  def glDeleteRenderbuffers(buffers: Buffer[Int]): Unit = {
    GLES20.glDeleteRenderbuffers(buffers)
  }

  def glDeleteShader(shader: Int): Unit = {
    GLES20.glDeleteShader(shader)
  }

  def glDeleteTextures(textures: Buffer[Int]): Unit = {
    GLES20.glDeleteTextures(textures)
  }

  def glDepthFunc(func: Int): Unit = {
    GLES20.glDepthFunc(func)
  }

  def glDepthMask(flag: Boolean): Unit = {
    GLES20.glDepthMask(flag)
  }

  def glDepthRangef(near: Float, far: Float): Unit = {
    GLES20.glDepthRangef(near, far)
  }

  def glDetachShader(program: Int, shader: Int): Unit = {
    GLES20.glDetachShader(program, shader)
  }

  def glDisable(cap: Int): Unit = {
    GLES20.glDisable(cap)
  }

  def glDisableVertexAttribArray(index: Int): Unit = {
    GLES20.glDisableVertexAttribArray(index)
  }

  def glDrawArrays(mode: Int, first: Int, count: Int): Unit = {
    GLES20.glDrawArrays(mode, first, count)
  }

  def glDrawElements(mode: Int, count: Int, tpe: Int, indices: Long): Unit = {
    GLES20.glDrawElements(mode, count, tpe, indices)
  }

  def glDrawElements(mode: Int, count: Int, tpe: Int, indices: Buffer[_]): Unit =
    (indices.tpe.primitive: @switch) match {
      case Buffer.PrimitiveTypes.BYTE => GLES20.glDrawElements(mode, tpe, indices.as[Byte].slice(count))
      case Buffer.PrimitiveTypes.SHORT => GLES20.glDrawElements(mode, indices.as[Short].slice(count))
      case Buffer.PrimitiveTypes.INT => GLES20.glDrawElements(mode, indices.as[Int].slice(count))
    }

  def glEnable(cap: Int): Unit = {
    GLES20.glEnable(cap)
  }

  def glEnableVertexAttribArray(index: Int): Unit = {
    GLES20.glEnableVertexAttribArray(index)
  }

  def glFinish(): Unit = {
    GLES20.glFinish()
  }

  def glFlush(): Unit = {
    GLES20.glFlush()
  }

  def glFramebufferRenderbuffer(target: Int, attachment: Int, bufferTarget: Int, buffer: Int): Unit = {
    GLES20.glFramebufferRenderbuffer(target, attachment, bufferTarget, buffer)
  }

  def glFramebufferTexture2D(target: Int, attachment: Int, textureTarget: Int, texture: Int, level: Int): Unit = {
    GLES20.glFramebufferTexture2D(target, attachment, textureTarget, texture, level)
  }

  def glFrontFace(mode: Int): Unit = {
    GLES20.glFrontFace(mode)
  }

  def glGenBuffers(buffer: Buffer[Int]): Unit = {
    GLES20.glGenBuffers(buffer)
  }

  def glGenFramebuffers(buffer: Buffer[Int]): Unit = {
    GLES20.glGenFramebuffers(buffer)
  }

  def glGenRenderbuffers(buffer: Buffer[Int]): Unit = {
    GLES20.glGenRenderbuffers(buffer)
  }

  def glGenTextures(buffer: Buffer[Int]): Unit = {
    GLES20.glGenTextures(buffer)
  }

  def glGenerateMipmap(target: Int): Unit = {
    GLES20.glGenerateMipmap(target)
  }

  def glGetBooleanv(pname: Int, buffer: Buffer[Byte]): Unit = {
    GLES20.glGetBooleanv(pname, buffer)
  }

  def glGetIntv(pname: Int, buffer: Buffer[Int]): Unit = {
    GLES20.glGetIntegerv(pname, buffer)
  }

  def glGetFloatv(pname: Int, buffer: Buffer[Float]): Unit = {
    GLES20.glGetFloatv(pname, buffer)
  }

  def glGetActiveAttrib(program: Int, index: Int, bufSize: Int): (Int, Int, String) = {
    val str = GLES20.glGetActiveAttrib(program, index, bufSize, ib1, ib2)
    (ib1.get(0), ib2.get(0), str)
  }

  def glGetActiveUniform(program: Int, index: Int, bufSize: Int): (Int, Int, String) = {
    val str = GLES20.glGetActiveUniform(program, index, bufSize, ib1, ib2)
    (ib1.get(0), ib2.get(0), str)
  }

  def glGetAttachedShaders(program: Int, buffer: Buffer[Int]): Int = {
    GLES20.glGetAttachedShaders(program, ib1, buffer)
    ib1.get(0)
  }

  def glGetAttribLocation(program: Int, name: String): Int = {
    GLES20.glGetAttribLocation(program, name)
  }

  def glGetBufferParameteriv(target: Int, value: Int, buffer: Buffer[Int]): Unit = {
    GLES20.glGetBufferParameteriv(target, value, buffer)
  }

  def glGetError(): Int = {
    GLES20.glGetError()
  }

  def glGetFramebufferAttachmentParameteriv(target: Int, attachment: Int, pname: Int, buffer: Buffer[Int]): Unit = {
    GLES20.glGetFramebufferAttachmentParameteriv(target, attachment, pname, buffer)
  }

  def glGetProgramInfoLog(program: Int, maxLength: Int): String = {
    GLES20.glGetProgramInfoLog(program, maxLength)
  }

  def glGetProgramiv(program: Int, pname: Int, buffer: Buffer[Int]): Unit = {
    GLES20.glGetProgramiv(program, pname, buffer)
  }

  def glGetRenderbufferParameteriv(target: Int, pname: Int, buffer: Buffer[Int]): Unit = {
    GLES20.glGetRenderbufferParameteriv(target, pname, buffer)
  }

  def glGetShaderInfoLog(shader: Int, maxLength: Int): String = {
    GLES20.glGetShaderInfoLog(shader, maxLength)
  }

  def glGetShaderPrecisionFormat(shaderType: Int, precisionType: Int): (Int, Int) = {
    GLES20.glGetShaderPrecisionFormat(shaderType, precisionType, ib1, ib2)
    (ib1.get(0), ib2.get(0))
  }

  def glGetShaderSource(shader: Int, bufSize: Int): String = {
    GLES20.glGetShaderSource(shader, bufSize)
  }

  def glGetShaderiv(shader: Int, pname: Int, buffer: Buffer[Int]): Unit = {
    GLES20.glGetShaderiv(shader, pname, buffer)
  }

  def glGetString(name: Int): String = {
    GLES20.glGetString(name)
  }

  def glGetTexParameteriv(target: Int, pname: Int, buffer: Buffer[Int]): Unit = {
    GLES20.glGetTexParameteriv(target, pname, buffer)
  }

  def glGetTexParameterfv(target: Int, pname: Int, buffer: Buffer[Float]): Unit = {
    GLES20.glGetTexParameterfv(target, pname, buffer)
  }

  def glGetUniformiv(program: Int, location: Int, buffer: Buffer[Int]): Unit = {
    GLES20.glGetUniformiv(program, location, buffer)
  }

  def glGetUniformfv(program: Int, location: Int, buffer: Buffer[Float]): Unit = {
    GLES20.glGetUniformfv(program, location, buffer)
  }

  def glGetUniformLocation(program: Int, name: String): Int = {
    GLES20.glGetUniformLocation(program, name)
  }

  def glGetVertexAttribiv(index: Int, pname: Int, buffer: Buffer[Int]): Unit = {
    GLES20.glGetVertexAttribiv(index, pname, buffer)
  }

  def glGetVertexAttribfv(index: Int, pname: Int, buffer: Buffer[Float]): Unit = {
    GLES20.glGetVertexAttribfv(index, pname, buffer)
  }

  def glHint(target: Int, mode: Int): Unit = {
    GLES20.glHint(target, mode)
  }

  def glIsBuffer(buffer: Int): Boolean = {
    GLES20.glIsBuffer(buffer)
  }

  def glIsEnabled(cap: Int): Boolean = {
    GLES20.glIsEnabled(cap)
  }

  def glIsFramebuffer(buffer: Int): Boolean = {
    GLES20.glIsFramebuffer(buffer)
  }

  def glIsProgram(program: Int): Boolean = {
    GLES20.glIsProgram(program)
  }

  def glIsRenderbuffer(buffer: Int): Boolean = {
    GLES20.glIsRenderbuffer(buffer)
  }

  def glIsShader(shader: Int): Boolean = {
    GLES20.glIsShader(shader)
  }

  def glIsTexture(texture: Int): Boolean = {
    GLES20.glIsTexture(texture)
  }

  def glLineWidth(width: Float): Unit = {
    GLES20.glLineWidth(width)
  }

  def glLinkProgram(program: Int): Unit = {
    GLES20.glLinkProgram(program)
  }

  def glPixelStorei(param: Int, value: Int): Unit = {
    GLES20.glPixelStorei(param, value)
  }

  def glPolygonOffset(factor: Float, units: Float): Unit = {
    GLES20.glPolygonOffset(factor, units)
  }

  def glReadPixels(x: Int, y: Int, width: Int, height: Int, format: Int, tpe: Int, buffer: Buffer[_]): Unit =
    (buffer.tpe.primitive: @switch) match {
      case Buffer.PrimitiveTypes.BYTE => GLES20.glReadPixels(x, y, width, height, format, tpe, buffer.as[Byte])
      case Buffer.PrimitiveTypes.SHORT => GLES20.glReadPixels(x, y, width, height, format, tpe, buffer.as[Short])
      case Buffer.PrimitiveTypes.INT => GLES20.glReadPixels(x, y, width, height, format, tpe, buffer.as[Int])
      case Buffer.PrimitiveTypes.FLOAT => GLES20.glReadPixels(x, y, width, height, format, tpe, buffer.as[Float])
    }

  def glReleaseShaderCompiler(): Unit = {
    GLES20.glReleaseShaderCompiler()
  }

  def glRenderbufferStorage(target: Int, format: Int, width: Int, height: Int): Unit = {
    GLES20.glRenderbufferStorage(target, format, width, height)
  }

  def glSampleCoverage(value: Float, invert: Boolean): Unit = {
    GLES20.glSampleCoverage(value, invert)
  }

  def glScissor(x: Int, y: Int, width: Int, height: Int): Unit = {
    GLES20.glScissor(x, y, width, height)
  }

  def glShaderBinary(format: Int, shaders: Buffer[Int], binary: Buffer[_]): Unit = {
    GLES20.glShaderBinary(shaders, format, binary.as[Byte])
  }

  def glShaderSource(shader: Int, sources: Array[String]): Unit = {
    GLES20.glShaderSource(shader, sources : _*)
  }

  def glStencilFunc(func: Int, ref: Int, mask: Int): Unit = {
    GLES20.glStencilFunc(func, ref, mask)
  }

  def glStencilFuncSeparate(face: Int, func: Int, ref: Int, mask: Int): Unit = {
    GLES20.glStencilFuncSeparate(face, func, ref, mask)
  }

  def glStencilMask(mask: Int): Unit = {
    GLES20.glStencilMask(mask)
  }

  def glStencilMaskSeparate(face: Int, mask: Int): Unit = {
    GLES20.glStencilMaskSeparate(face, mask)
  }

  def glStencilOp(fail: Int, zfail: Int, zpass: Int): Unit = {
    GLES20.glStencilOp(fail, zfail, zpass)
  }

  def glStencilOpSeparate(face: Int, fail: Int, zfail: Int, zpass: Int): Unit = {
    GLES20.glStencilOpSeparate(face, fail, zfail, zpass)
  }

  def glTexImage2D(target: Int, level: Int, internalformat: Int,
    width: Int, height: Int, border: Int, format: Int, tpe: Int, data: Buffer[_]): Unit = (data.tpe.primitive: @switch) match {
      case Buffer.PrimitiveTypes.BYTE => GLES20.glTexImage2D(target, level, internalformat, width, height, border, format, tpe, data.as[Byte])
      case Buffer.PrimitiveTypes.SHORT => GLES20.glTexImage2D(target, level, internalformat, width, height, border, format, tpe, data.as[Short])
      case Buffer.PrimitiveTypes.INT => GLES20.glTexImage2D(target, level, internalformat, width, height, border, format, tpe, data.as[Int])
      case Buffer.PrimitiveTypes.FLOAT => GLES20.glTexImage2D(target, level, internalformat, width, height, border, format, tpe, data.as[Float])
    }

  def glTexParameteriv(target: Int, param: Int, value: Buffer[Int]): Unit = {
    GLES20.glTexParameteriv(target, param, value)
  }

  def glTexParameterfv(target: Int, param: Int, value: Buffer[Float]): Unit = {
    GLES20.glTexParameterfv(target, param, value)
  }

  def glTexSubImage2D(target: Int, level: Int, xoffset: Int, yoffset: Int,
    width: Int, height: Int, format: Int, tpe: Int, data: Buffer[_]): Unit = (data.tpe.primitive: @switch) match {
      case Buffer.PrimitiveTypes.BYTE => GLES20.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, tpe, data.as[Byte])
      case Buffer.PrimitiveTypes.SHORT => GLES20.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, tpe, data.as[Short])
      case Buffer.PrimitiveTypes.INT => GLES20.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, tpe, data.as[Int])
      case Buffer.PrimitiveTypes.FLOAT => GLES20.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, tpe, data.as[Float])
    }

  def glUniform1i(location: Int, x: Int): Unit = GLES20.glUniform1i(location, x)
  def glUniform2i(location: Int, x: Int, y: Int): Unit = GLES20.glUniform2i(location, x, y)
  def glUniform3i(location: Int, x: Int, y: Int, z: Int): Unit = GLES20.glUniform3i(location, x, y, z)
  def glUniform4i(location: Int, x: Int, y: Int, z: Int, w: Int): Unit = GLES20.glUniform4i(location, x, y, z, w)

  def glUniform1f(location: Int, x: Float): Unit = GLES20.glUniform1f(location, x)
  def glUniform2f(location: Int, x: Float, y: Float): Unit = GLES20.glUniform2f(location, x, y)
  def glUniform3f(location: Int, x: Float, y: Float, z: Float): Unit = GLES20.glUniform3f(location, x, y, z)
  def glUniform4f(location: Int, x: Float, y: Float, z: Float, w: Float): Unit = GLES20.glUniform4f(location, x, y, z, w)

  def glUniform1iv(location: Int, count: Int, buffer: Buffer[Int]): Unit = GLES20.glUniform1iv(location, buffer.slice(count))
  def glUniform2iv(location: Int, count: Int, buffer: Buffer[Int]): Unit = GLES20.glUniform2iv(location, buffer.slice(count >> 1))
  def glUniform3iv(location: Int, count: Int, buffer: Buffer[Int]): Unit = GLES20.glUniform3iv(location, buffer.slice(count * 3))
  def glUniform4iv(location: Int, count: Int, buffer: Buffer[Int]): Unit = GLES20.glUniform4iv(location, buffer.slice(count >> 2))

  def glUniform1fv(location: Int, count: Int, buffer: Buffer[Float]): Unit = GLES20.glUniform1fv(location, buffer.slice(count))
  def glUniform2fv(location: Int, count: Int, buffer: Buffer[Float]): Unit = GLES20.glUniform2fv(location, buffer.slice(count >> 1))
  def glUniform3fv(location: Int, count: Int, buffer: Buffer[Float]): Unit = GLES20.glUniform3fv(location, buffer.slice(count * 3))
  def glUniform4fv(location: Int, count: Int, buffer: Buffer[Float]): Unit = GLES20.glUniform4fv(location, buffer.slice(count >> 2))

  def glUniformMatrix2fv(location: Int, count: Int, transpose: Boolean, buffer: Buffer[Float]): Unit = GLES20.glUniformMatrix2fv(location, transpose, buffer.slice(count >> 2))
  def glUniformMatrix3fv(location: Int, count: Int, transpose: Boolean, buffer: Buffer[Float]): Unit = GLES20.glUniformMatrix3fv(location, transpose, buffer.slice(count * (3 * 3)))
  def glUniformMatrix4fv(location: Int, count: Int, transpose: Boolean, buffer: Buffer[Float]): Unit = GLES20.glUniformMatrix4fv(location, transpose, buffer.slice(count >> 4))

  def glUseProgram(program: Int): Unit = {
    GLES20.glUseProgram(program)
  }

  def glValidateProgram(program: Int): Unit = {
    GLES20.glValidateProgram(program)
  }

  def glVertexAttrib1f(index: Int, x: Float): Unit = GLES20.glVertexAttrib1f(index, x)
  def glVertexAttrib2f(index: Int, x: Float, y: Float): Unit = GLES20.glVertexAttrib2f(index, x, y)
  def glVertexAttrib3f(index: Int, x: Float, y: Float, z: Float): Unit = GLES20.glVertexAttrib3f(index, x, y, z)
  def glVertexAttrib4f(index: Int, x: Float, y: Float, z: Float, w: Float): Unit = GLES20.glVertexAttrib4f(index, x, y, z, w)

  def glVertexAttrib1fv(index: Int, buffer: Buffer[Float]): Unit = GLES20.glVertexAttrib1fv(index, buffer.slice(1))
  def glVertexAttrib2fv(index: Int, buffer: Buffer[Float]): Unit = GLES20.glVertexAttrib2fv(index, buffer.slice(2))
  def glVertexAttrib3fv(index: Int, buffer: Buffer[Float]): Unit = GLES20.glVertexAttrib3fv(index, buffer.slice(3))
  def glVertexAttrib4fv(index: Int, buffer: Buffer[Float]): Unit = GLES20.glVertexAttrib4fv(index, buffer.slice(4))

  def glVertexAttribPointer(index: Int, size: Int, tpe: Int, normalized: Boolean, stride: Int, offset: Int): Unit = {
    GLES20.glVertexAttribPointer(index, size, tpe, normalized, stride, offset)
  }

  def glViewport(x: Int, y: Int, width: Int, height: Int): Unit = {
    GLES20.glViewport(x, y, width, height)
  }
}
