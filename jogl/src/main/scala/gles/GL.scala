package gles

import scala.reflect._

class GL(private[this] val gl: com.jogamp.opengl.GL2ES2) extends GLSpec {

  private[this] class ArrayProvider[@specialized(Byte, Int) T : ClassTag] {
    private[this] var array = new Array[T](1024)
    @inline def get(minSize: Int): Array[T] = {
      if (array.length < minSize) {
        var newSize = array.length
        while (newSize < minSize) newSize *= 2
        array = new Array[T](newSize)
      }
      array
    }
  }

  private[this] val byteArray = new ArrayProvider[Byte]
  private[this] val intArray = new ArrayProvider[Int]

  def glActiveTexture(texture: Int): Unit = {
    gl.glActiveTexture(texture)
  }

  def glAttachShader(program: Int, shader: Int): Unit = {
    gl.glAttachShader(program, shader)
  }

  def glBindAttribLocation(program: Int, index: Int, name: String): Unit = {
    gl.glBindAttribLocation(program, index, name)
  }

  def glBindBuffer(target: Int, buffer: Int): Unit = {
    gl.glBindBuffer(target, buffer)
  }

  def glBindFramebuffer(target: Int, buffer: Int): Unit = {
    gl.glBindFramebuffer(target, buffer)
  }

  def glBindRenderbuffer(target: Int, buffer: Int): Unit = {
    gl.glBindRenderbuffer(target, buffer)
  }

  def glBindTexture(target: Int, texture: Int): Unit = {
    gl.glBindTexture(target, texture)
  }

  def glBlendColor(red: Float, green: Float, blue: Float, alpha: Float): Unit = {
    gl.glBlendColor(red, green, blue, alpha)
  }

  def glBlendEquation(mode: Int): Unit = {
    gl.glBlendEquation(mode)
  }

  def glBlendEquationSeparate(rgb: Int, alpha: Int): Unit = {
    gl.glBlendEquationSeparate(rgb, alpha)
  }

  def glBlendFunc(sfactor: Int, dfactor: Int): Unit = {
    gl.glBlendFunc(sfactor, dfactor)
  }

  def glBlendFuncSeparate(rgbSrc: Int, rgbDst: Int, alphaSrc: Int, alphaDst: Int): Unit = {
    gl.glBlendFuncSeparate(rgbSrc, rgbDst, alphaSrc, alphaDst)
  }

  def glBufferData(target: Int, size: Long, data: Buffer[_], usage: Int): Unit = {
    gl.glBufferData(target, size, data, usage)
  }

  def glBufferSubData(target: Int, offset: Long, size: Long, data: Buffer[_]): Unit = {
    gl.glBufferSubData(target, offset, size, data)
  }

  def glCheckFramebufferStatus(target: Int): Int = {
    gl.glCheckFramebufferStatus(target)
  }

  def glClear(mask: Int): Unit = {
    gl.glClear(mask)
  }

  def glClearColor(red: Float, green: Float, blue: Float, alpha: Float): Unit = {
    gl.glClearColor(red, green, blue, alpha)
  }

  def glClearDepth(depth: Float): Unit = {
    gl.glClearDepth(depth)
  }

  def glClearStencil(s: Int): Unit = {
    gl.glClearSentic(s)
  }

  def glColorMask(red: Boolean, green: Boolean, blue: Boolean, alpha: Boolean): Unit = {
    gl.glColorMask(red, green, blue, alpha)
  }

  def glCompileShader(shader: Int): Unit = {
    gl.glCompileShader(shader)
  }

  def glCompressedTexImage2D(target: Int, level: Int, format: Int,
    width: Int, height: Int, border: Int, imageSize: Int, data: Buffer[_]): Unit = {
    gl.glCompressedTexImage2D(target, level, format, width, height, border, imageSize, data.nioBuffer)
  }

  def glCompressedTexSubImage2D(target: Int, level: Int, xoffset: Int, yoffset: Int,
    width: Int, height: Int, format: Int, imageSize: Int, data: Buffer[_]): Unit = {
    gl.glCompressedTexSubImage2D(target, level, xoffset, yoffset, width, height, format, imageSize, data.nioBuffer)
  }

  def glCopyTexImage2D(target: Int, level: Int, format: Int, x: Int, y: Int,
    width: Int, height: Int, border: Int): Unit = {
    gl.glCopyTexImage2D(target, level, format, x, y, width, height, border)
  }

  def glCopyTexSubImage2D(target: Int, level: Int, xoffset: Int, yoffset: Int, x: Int, y: Int,
    width: Int, height: Int): Unit = {
    gl.glCopyTexSubImage2D(target, level, xoffset, yoffset, x, y, width, height)
  }

  def glCreateProgram(): Int = {
    gl.glCreateProgram()
  }

  def glCreateShader(shaderType: Int): Int = {
    gl.glCreateShader(shaderType)
  }

  def glCullFace(mode: Int): Unit = {
    gl.glCullFace(mode)
  }

  def glDeleteBuffers(buffers: Buffer[Int]): Unit = {
    gl.glDeleteBuffers(buffers.size, buffers.data, buffers.start)
  }

  def glDeleteFramebuffers(buffers: Buffer[Int]): Unit = {
    gl.glDeleteFramebuffers(buffers.size, buffers.data, buffers.start)
  }

  def glDeleteProgram(program: Int): Unit = {
    gl.glDeleteProgram(program)
  }

  def glDeleteRenderbuffers(buffers: Buffer[Int]): Unit = {
    gl.glDeleteRenderbuffers(bufferes.size, buffers.data, buffers.start)
  }

  def glDeleteShader(shader: Int): Unit = {
    gl.glDeleteShader(shader)
  }

  def glDeleteTextures(textures: Buffer[Int]): Unit = {
    gl.glDeleteTextures(textures.size, textures)
  }

  def glDepthFunc(func: Int): Unit = {
    gl.glDepthFunc(func)
  }

  def glDepthMask(flag: Boolean): Unit = {
    gl.glDepthMask(flag)
  }

  def glDepthRangef(near: Float, far: Float): Unit = {
    gl.glDepthRangef(near, far)
  }

  def glDetachShader(program: Int, shader: Int): Unit = {
    gl.glDetachShader(program, shader)
  }

  def glDisable(cap: Int): Unit = {
    gl.glDisable(cap)
  }

  def glDisableVertexAttribArray(index: Int): Unit = {
    gl.glDisableVertexAttribArray(index)
  }

  def glDrawArrays(mode: Int, first: Int, count: Int): Unit = {
    gl.glDrawArrays(mode, first, count)
  }

  def glDrawElements(mode: Int, count: Int, tpe: Int, indices: Buffer[_]): Unit = {
    gl.glDrawElements(mode, count, tpe, indices)
  }

  def glEnable(cap: Int): Unit = {
    gl.glEnable(cap)
  }

  def glEnableVertexAttribArray(index: Int): Unit = {
    gl.glEnableVertexAttribArray(index)
  }

  def glFinish(): Unit = {
    gl.glFinish()
  }

  def glFlush(): Unit = {
    gl.glFlush()
  }

  def glFramebufferRenderbuffer(target: Int, attachment: Int, bufferTarget: Int, buffer: Int): Unit = {
    gl.glFramebufferRenderbuffer(target, attachment, bufferTarget, buffer)
  }

  def glFramebufferTexture2D(target: Int, attachment: Int, textureTarget: Int, texture: Int, level: Int): Unit = {
    gl.glFramebufferTexture2D(target, attachment, textureTarget, texture, level)
  }

  def glFrontFace(mode: Int): Unit = {
    gl.glFrontFace(mode)
  }

  def glGenBuffers(buffer: Buffer[Int]): Unit = {
    gl.glGenBuffers(buffer.size, buffer.data, buffer.start)
  }

  def glGenFramebuffers(buffer: Buffer[Int]): Unit = {
    gl.glGenFramebuffers(buffer.size, buffer.data, buffer.start)
  }

  def glGenRenderbuffers(buffer: Buffer[Int]): Unit = {
    gl.glGenRenderbuffers(buffer.size, buffer.data, buffer.start)
  }

  def glGenTextures(buffer: Buffer[Int]): Unit = {
    gl.glGenTextures(buffer.size, buffer.data, buffer.start)
  }

  def glGenerateMipmap(target: Int): Unit = {
    gl.glGenerateMipmap(target)
  }

  def glGetBooleanv(pname: Int, buffer: Buffer[Byte]): Unit = {
    gl.glGetBooleanv(pname, buffer.data, buffer.start)
  }

  def glGetIntv(pname: Int, buffer: Buffer[Int]): Unit = {
    gl.glGetIntegerv(pname, buffer.data, buffer.start)
  }

  def glGetFloatv(pname: Int, buffer: Buffer[Float]): Unit = {
    gl.glGetFloatv(pname, buffer.data, buffer.start)
  }

  def glGetActiveAttrib(program: Int, index: Int, bufSize: Int): (Int, Int, String) = {
    val attributes = intArray.get(3)
    val name = byteArray.get(bufSize)
    gl.glGetActiveAttrib(program, index, bufSize, attributes, 0, attributes, 1, attributes, 2, name, 0)
    (attributes(1), attributes(2), new String(name, 0, attributes(0)))
  }

  def glGetActiveUniform(program: int, index: Int, bufSize: Int): (Int, Int, String) = {
    val attributes = intArray.get(3)
    val name = byteArray.get(bufSize)
    gl.glGetActiveUniform(program, index, bufSize, attributes, 0, attributes, 1, attributes, 2, name, 0)
    (attributes(1), attributes(2), new String(name, 0, attributes(0)))
  }

  def glGetAttachedShaders(program: Int, buffer: Buffer[Int]): Int = {
    val count = java.nio.IntBuffer.allocate(1)
    gl.glGetAttachedShaders(program, buffer.size, count, buffer)
    count.get(0)
  }

  def glGetAttribLocation(program: Int, name: String): Int = {
    gl.glGetAttribLocation(program, name)
  }

  def glGetBufferParameteriv(target: Int, value: Int, buffer: Buffer[Int]): Unit = {
    gl.glGetBufferParameteriv(target, value, buffer)
  }

  def glGetError(): Int = {
    gl.glGetError()
  }

  def glGetFramebufferAttachmentParameteriv(target: Int, attachment: Int, pname: Int, buffer: Buffer[Int]): Unit = {
    gl.glGetFramebufferAttachmentParameteriv(target, attachment, pname, buffer.data, buffer.start)
  }

  def glGetProgramInfoLog(program: Int, maxLength: Int): String = {
    val bytes = byteArray.get(maxLength)
    val length = intArray.get(1)
    gl.glGetProgramInfoLog(program, maxLength, length, 0, bytes, 0)
    new String(bytes, 0, length(0))
  }

  def glGetProgramiv(program: Int, pname: Int, buffer: Buffer[Int]): Unit = {
    gl.glGetProgramiv(program, pname, buffer.data, buffer.start)
  }

  def glGetRenderbufferParameteriv(target: Int, pname: Int, buffer: Buffer[Int]): Unit = {
    gl.glGetRenderbufferParameteriv(target, pname, buffer.data, buffer.start)
  }

  def glGetShaderInfoLog(shader: Int, maxLength: Int): String = {
    val bytes = byteArray.get(maxLength)
    val length = intArray.get(1)
    gl.glGetShaderInfoLog(shader, maxLength, length, 0, bytes, 0)
    new String(bytes, 0, length(0))
  }

  def glGetShaderPrecisionFormat(shaderType: Int, precisionType: Int): (Int, Int) = {
    val results = intArray.get(2)
    gl.glGetShaderPrecisionFormat(shaderType, precisionType, results, 0, results, 1)
    (results(0), results(1))
  }

  def glGetShaderSource(shader: Int, bufSize: Int): String = {
    val bytes = byteArray.get(bufSize)
    val length = intArray.get(1)
    gl.glGetShaderSource(shader, bufSize, length, 0, bytes, 0)
    new String(bytes, 0, length(0))
  }

  def glGetShaderiv(shader: Int, pname: Int, buffer: Buffer[Int]): Unit = {
    gl.glGetShaderiv(shader, pname, buffer.data, buffer.start)
  }

  def glGetString(name: Int): String = {
    gl.glGetString(name)
  }

  def glGetTexParameteriv(target: Int, pname: Int, buffer: Buffer[Int]): Unit = {
    gl.glGetTexParameteriv(target, pname, buffer.data, buffer.start)
  }

  def glGetTexParameterfv(target: Int, pname: Int, buffer: Buffer[Float]): Unit = {
    gl.glGetTexParameterfv(target, pname, buffer.data, buffer.start)
  }

  def glGetUniformiv(program: Int, location: Int, buffer: Buffer[Int]): Unit = {
    gl.glGetUniformiv(program, location, buffer.data, buffer.start)
  }

  def glGetUniformfv(program: Int, location: Int, buffer: Buffer[Float]): Unit = {
    gl.glGetUniformfv(program, location, buffer.data, buffer.start)
  }

  def glGetUniformLocation(program: Int, name: String): Int = {
    gl.glGetUniformLocation(program, name)
  }

  def glGetVertexAttribiv(index: Int, pname: Int, buffer: Buffer[Int]): Unit = {
    gl.glGetVertexAttribiv(index, pname, buffer.data, buffer.start)
  }

  def glGetVertexAttribfv(index: Int, pname: Int, buffer: Buffer[Float]): Unit = {
    gl.glGetVertexAttribfv(index, pname, buffer.data, buffer.start)
  }

  def glHint(target: Int, mode: Int): Unit = {
    gl.glHint(target, mode)
  }

  def glIsBuffer(buffer: Int): Boolean = {
    gl.glIsBuffer(buffer)
  }

  def glIsEnabled(cap: Int): Boolean = {
    gl.glIsEnabled(cap)
  }

  def glIsFramebuffer(buffer: Int): Boolean = {
    gl.glIsFramebuffer(buffer)
  }

  def glIsProgram(program: Int): Boolean = {
    gl.glIsProgram(program)
  }

  def glIsRenderbuffer(buffer: Int): Boolean = {
    gl.glIsRenderbuffer(buffer)
  }

  def glIsShader(shader: Int): Boolean = {
    gl.glIsShader(shader)
  }

  def glIsTexture(texture: Int): Boolean = {
    gl.glIsTexture(texture)
  }

  def glLineWidth(width: Float): Unit = {
    gl.glLineWidth(width)
  }

  def glLinkProgram(program: Int): Unit = {
    gl.glLinkProgram(program)
  }

  def glPixelStorei(param: Int, value: Int): Unit = {
    gl.glPixelStorei(param, value)
  }

  def glPolygonOffset(factor: Float, units: Float): Unit = {
    gl.glPolygonOffset(factor, units)
  }

  def glReadPixels(x: Int, y: Int, width: Int, height: Int, format: Int, tpe: Int, buffer: Buffer[_]): Unit = {
    gl.glReadPixels(x, y, width, height, format, tpe, buffer.nioBuffer)
  }

  def glReleaseShaderCompiler(): Unit = {
    gl.glReleaseShaderCompiler()
  }

  def glRenderbufferStorage(target: Int, format: Int, width: Int, height: Int): Unit = {
    gl.glRenderbufferStorage(target, format, width, height)
  }

  def glSampleCoverage(value: Float, invert: Boolean): Unit = {
    gl.glSampleCoverage(value, invert)
  }

  def glScissor(x: Int, y: Int, width: Int, height: Int): Unit = {
    gl.glScissor(x, y, width, height)
  }

  def glShaderBinary(format: Int, shaders: Buffer[Int], binary: Buffer[_]): Unit = {
    gl.glShaderBinary(shaders.size, shaders.data, shaders.start, format, binary.nioBuffer)
  }

  def glShaderSource(shader: Int, sources: Array[String]): Unit = {
    val lengths = intArray.get(sources.length)
    for (i <- 0 until sources.length) lengths(i) = sources(i).length
    gl.glShaderSource(shader, sources.length, sources, lengths, 0)
  }

  def glStencilFunc(func: Int, ref: Int, mask: Int): Unit = {
    gl.glStencilFunc(func, ref, mask)
  }

  def glStencilFuncSeparate(face: Int, func: Int, ref: Int, mask: Int): Unit = {
    gl.glStencilFuncSeparate(face, func, ref, mask)
  }

  def glStencilMask(mask: Int): Unit = {
    gl.glStencilMask(mask)
  }

  def glStencilMaskSeparate(face: Int, mask: Int): Unit = {
    gl.glStencilMaskSeparate(face, mask)
  }

  def glStencilOp(fail: Int, zfail: Int, zpass: Int): Unit = {
    gl.glStencilOp(fail, zfail, zpass)
  }

  def glStencilOpSeparate(face: Int, fail: Int, zfail: Int, zpass: Int): Unit = {
    gl.glStencilOpSeparate(face, fail, zfail, zpass)
  }

  def glTexImage2D(target: Int, level: Int, internalformat: Int,
    width: Int, height: Int, border: Int, format: Int, tpe: Int, data: Buffer[_]): Unit = {
    gl.glTexImage2D(target, level, internalformat, width, height, border, format, tpe, data.nioBuffer
  }

  def glTexParameteriv(target: Int, param: Int, value: Buffer[Int]): Unit = {
    gl.glTexParameteriv(target, param, value.data, value.start)
  }

  def glTexParameterfv(target: Int, param: Int, value: Buffer[Float]): Unit = {
    gl.glTexParameterfv(target, param, value.data, value.start)
  }

  def glTexSubImage2D(target: Int, level: Int, xoffset: Int, yoffset: Int,
    width: Int, height: Int, format: Int, tpe: Int, data: Buffer[_]): Unit = {
    gl.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, tpe, data.nioBuffer)
  }

  def glUniform1i(location: Int, x: Int): Unit = gl.glUniform1i(location, x)
  def glUniform2i(location: Int, x: Int, y: Int): Unit = gl.glUniform2i(location, x, y)
  def glUniform3i(location: Int, x: Int, y: Int, z: Int): Unit = gl.glUniform3i(location, x, y, z)
  def glUniform4i(location: Int, x: Int, y: Int, z: Int, w: Int): Unit = gl.glUniform4i(location, x, y, z, w)

  def glUniform1f(location: Int, x: Float): Unit = gl.glUniform1f(location, x)
  def glUniform2f(location: Int, x: Float, y: Float): Unit = gl.glUniform2f(location, x, y)
  def glUniform3f(location: Int, x: Float, y: Float, z: Float): Unit = gl.glUniform3f(location, x, y, z)
  def glUniform4f(location: Int, x: Float, y: Float, z: Float, w: Float): Unit = gl.glUniform4f(location, x, y, z, w)

  def glUniform1iv(location: Int, count: Int, buffer: Buffer[Int]): Unit = gl.glUniform1iv(location, count, buffer.data, buffer.start)
  def glUniform2iv(location: Int, count: Int, buffer: Buffer[Int]): Unit = gl.glUniform2iv(location, count, buffer.data, buffer.start)
  def glUniform3iv(location: Int, count: Int, buffer: Buffer[Int]): Unit = gl.glUniform3iv(location, count, buffer.data, buffer.start)
  def glUniform4iv(location: Int, count: Int, buffer: Buffer[Int]): Unit = gl.glUniform4iv(location, count, buffer.data, buffer.start)

  def glUniform1fv(location: Int, count: Int, buffer: Buffer[Float]): Unit = gl.glUniform1fv(location, count, buffer.data, buffer.start)
  def glUniform2fv(location: Int, count: Int, buffer: Buffer[Float]): Unit = gl.glUniform2fv(location, count, buffer.data, buffer.start)
  def glUniform3fv(location: Int, count: Int, buffer: Buffer[Float]): Unit = gl.glUniform3fv(location, count, buffer.data, buffer.start)
  def glUniform4fv(location: Int, count: Int, buffer: Buffer[Float]): Unit = gl.glUniform4fv(location, count, buffer.data, buffer.start)

  def glUniformMatrix2fv(location: Int, count: Int, transpose: Boolean, buffer: Buffer[Float]): Unit = gl.glUniformMatrix2fv(location, count, transpose, buffer.data, buffer.start)
  def glUniformMatrix3fv(location: Int, count: Int, transpose: Boolean, buffer: Buffer[Float]): Unit = gl.glUniformMatrix3fv(location, count, transpose, buffer.data, buffer.start)
  def glUniformMatrix4fv(location: Int, count: Int, transpose: Boolean, buffer: Buffer[Float]): Unit = gl.glUniformMatrix4fv(location, count, transpose, buffer.data, buffer.start)

  def glUseProgram(program: Int): Unit = {
    gl.glUseProgram(program)
  }

  def glValidateProgram(program: Int): Unit = {
    gl.glValidateProgram(program)
  }

  def glVertexAttrib1f(index: Int, x: Float): Unit = gl.glVertexAttrib1f(index, x)
  def glVertexAttrib2f(index: Int, x: Float, y: Float): Unit = gl.glVertexAttrib1f(index, x, y)
  def glVertexAttrib3f(index: Int, x: Float, y: Float, z: Float): Unit = gl.glVertexAttrib1f(index, x, y, z)
  def glVertexAttrib4f(index: Int, x: Float, y: Float, z: Float, w: Float): Unit = gl.glVertexAttrib1f(index, x, y, z, w)

  def glVertexAttrib1fv(index: Int, buffer: Buffer[Float]): Unit = gl.glVertexAttrib1fv(index, buffer.data, buffer.start)
  def glVertexAttrib2fv(index: Int, buffer: Buffer[Float]): Unit = gl.glVertexAttrib2fv(index, buffer.data, buffer.start)
  def glVertexAttrib3fv(index: Int, buffer: Buffer[Float]): Unit = gl.glVertexAttrib3fv(index, buffer.data, buffer.start)
  def glVertexAttrib4fv(index: Int, buffer: Buffer[Float]): Unit = gl.glVertexAttrib4fv(index, buffer.data, buffer.start)

  def glVertexAttribPointer(index: Int, size: Int, tpe: Int, normalized: Boolean, stride: Int, offset: Int): Unit = {
    gl.glVertexAttribPointer(index, size, tpe, normalized, stride, offset)
  }

  def glViewport(x: Int, y: Int, width: Int, height: Int): Unit = {
    gl.glViewport(x, y, width, height)
  }
}
