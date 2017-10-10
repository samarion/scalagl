package scalagl.gl

trait GLES2 {

  def glActiveTexture(texture: Int): Unit

  def glAttachShader(program: Int, shader: Int): Unit

  def glBindAttribLocation(program: Int, index: Int, name: String): Unit

  def glBindBuffer(target: Int, buffer: Int): Unit

  def glBindFramebuffer(target: Int, buffer: Int): Unit

  def glBindRenderbuffer(target: Int, buffer: Int): Unit

  def glBindTexture(target: Int, texture: Int): Unit

  def glBlendColor(red: Float, green: Float, blue: Float, alpha: Float): Unit

  def glBlendEquation(mode: Int): Unit

  def glBlendEquationSeparate(rgb: Int, alpha: Int): Unit

  def glBlendFunc(sfactor: Int, dfactor: Int): Unit

  def glBlendFuncSeparate(rgbSrc: Int, rgbDst: Int, alphaSrc: Int, alphaDst: Int): Unit

  def glBufferData(target: Int, size: Long, usage: Int): Unit

  def glBufferData(target: Int, data: Buffer[_], usage: Int): Unit

  def glBufferSubData(target: Int, offset: Long, data: Buffer[_]): Unit

  def glCheckFramebufferStatus(target: Int): Int

  def glClear(mask: Int): Unit

  def glClearColor(red: Float, green: Float, blue: Float, alpha: Float): Unit

  def glClearDepth(depth: Float): Unit

  def glClearStencil(s: Int): Unit

  def glColorMask(red: Boolean, green: Boolean, blue: Boolean, alpha: Boolean): Unit

  def glCompileShader(shader: Int): Unit

  def glCompressedTexImage2D(target: Int, level: Int, format: Int,
                             width: Int, height: Int, border: Int, imageSize: Int, pointer: Long): Unit

  def glCompressedTexImage2D(target: Int, level: Int, format: Int,
                             width: Int, height: Int, border: Int, imageSize: Int, data: Buffer[_]): Unit

  def glCompressedTexSubImage2D(target: Int, level: Int, xoffset: Int, yoffset: Int,
                                width: Int, height: Int, format: Int, imageSize: Int, pointer: Long): Unit

  def glCompressedTexSubImage2D(target: Int, level: Int, xoffset: Int, yoffset: Int,
                                width: Int, height: Int, format: Int, imageSize: Int, data: Buffer[_]): Unit

  def glCopyTexImage2D(target: Int, level: Int, format: Int, x: Int, y: Int,
                       width: Int, height: Int, border: Int): Unit

  def glCopyTexSubImage2D(target: Int, level: Int, xoffset: Int, yoffset: Int, x: Int, y: Int,
                          width: Int, height: Int): Unit

  def glCreateProgram(): Int

  def glCreateShader(shaderType: Int): Int

  def glCullFace(mode: Int): Unit

  def glDeleteBuffers(buffers: Buffer[Int]): Unit

  def glDeleteFramebuffers(buffers: Buffer[Int]): Unit

  def glDeleteProgram(program: Int): Unit

  def glDeleteRenderbuffers(buffers: Buffer[Int]): Unit

  def glDeleteShader(shader: Int): Unit

  def glDeleteTextures(textures: Buffer[Int]): Unit

  def glDepthFunc(func: Int): Unit

  def glDepthMask(flag: Boolean): Unit

  def glDepthRangef(near: Float, far: Float): Unit

  def glDetachShader(program: Int, shader: Int): Unit

  def glDisable(cap: Int): Unit

  def glDisableVertexAttribArray(index: Int): Unit

  def glDrawArrays(mode: Int, first: Int, count: Int): Unit

  def glDrawElements(mode: Int, count: Int, tpe: Int, indices: Long): Unit

  def glDrawElements(mode: Int, count: Int, tpe: Int, indices: Buffer[_]): Unit

  def glEnable(cap: Int): Unit

  def glEnableVertexAttribArray(index: Int): Unit

  def glFinish(): Unit

  def glFlush(): Unit

  def glFramebufferRenderbuffer(target: Int, attachment: Int, bufferTarget: Int, buffer: Int): Unit

  def glFramebufferTexture2D(target: Int, attachment: Int, textureTarget: Int, texture: Int, level: Int): Unit

  def glFrontFace(mode: Int): Unit

  def glGenBuffers(buffer: Buffer[Int]): Unit

  def glGenFramebuffers(buffer: Buffer[Int]): Unit

  def glGenRenderbuffers(buffer: Buffer[Int]): Unit

  def glGenTextures(buffer: Buffer[Int]): Unit

  def glGenerateMipmap(target: Int): Unit

  def glGetBooleanv(pname: Int, buffer: Buffer[Byte]): Unit

  def glGetIntv(pname: Int, buffer: Buffer[Int]): Unit

  def glGetFloatv(pname: Int, buffer: Buffer[Float]): Unit

  def glGetActiveAttrib(program: Int, index: Int, bufSize: Int): (Int, Int, String)

  def glGetActiveUniform(program: Int, index: Int, bufSize: Int): (Int, Int, String)

  def glGetAttachedShaders(program: Int, buffer: Buffer[Int]): Int

  def glGetAttribLocation(program: Int, name: String): Int

  def glGetBufferParameteriv(target: Int, value: Int, buffer: Buffer[Int]): Unit

  def glGetError(): Int

  def glGetFramebufferAttachmentParameteriv(target: Int, attachment: Int, pname: Int, buffer: Buffer[Int]): Unit

  def glGetProgramInfoLog(program: Int, maxLength: Int): String

  def glGetProgramiv(program: Int, pname: Int, buffer: Buffer[Int]): Unit

  def glGetRenderbufferParameteriv(target: Int, pname: Int, buffer: Buffer[Int]): Unit

  def glGetShaderInfoLog(shader: Int, maxLength: Int): String

  def glGetShaderPrecisionFormat(shaderType: Int, precisionType: Int): (Int, Int)

  def glGetShaderSource(shader: Int, bufSize: Int): String

  def glGetShaderiv(shader: Int, pname: Int, buffer: Buffer[Int]): Unit

  def glGetString(name: Int): String

  def glGetTexParameteriv(target: Int, pname: Int, buffer: Buffer[Int]): Unit

  def glGetTexParameterfv(target: Int, pname: Int, buffer: Buffer[Float]): Unit

  def glGetUniformiv(program: Int, location: Int, buffer: Buffer[Int]): Unit

  def glGetUniformfv(program: Int, location: Int, buffer: Buffer[Float]): Unit

  def glGetUniformLocation(program: Int, name: String): Int

  def glGetVertexAttribiv(index: Int, pname: Int, buffer: Buffer[Int]): Unit

  def glGetVertexAttribfv(index: Int, pname: Int, buffer: Buffer[Float]): Unit

  def glHint(target: Int, mode: Int): Unit

  def glIsBuffer(buffer: Int): Boolean

  def glIsEnabled(cap: Int): Boolean

  def glIsFramebuffer(buffer: Int): Boolean

  def glIsProgram(program: Int): Boolean

  def glIsRenderbuffer(buffer: Int): Boolean

  def glIsShader(shader: Int): Boolean

  def glIsTexture(texture: Int): Boolean

  def glLineWidth(width: Float): Unit

  def glLinkProgram(program: Int): Unit

  def glPixelStorei(param: Int, value: Int): Unit

  def glPolygonOffset(factor: Float, units: Float): Unit

  def glReadPixels(x: Int, y: Int, width: Int, height: Int, format: Int, tpe: Int, buffer: Buffer[_]): Unit

  def glReleaseShaderCompiler(): Unit

  def glRenderbufferStorage(target: Int, format: Int, width: Int, height: Int): Unit

  def glSampleCoverage(value: Float, invert: Boolean): Unit

  def glScissor(x: Int, y: Int, width: Int, height: Int): Unit

  def glShaderBinary(format: Int, shaders: Buffer[Int], binary: Buffer[_]): Unit

  def glShaderSource(shader: Int, sources: Array[String]): Unit

  def glStencilFunc(func: Int, ref: Int, mask: Int): Unit

  def glStencilFuncSeparate(face: Int, func: Int, ref: Int, mask: Int): Unit

  def glStencilMask(mask: Int): Unit

  def glStencilMaskSeparate(face: Int, mask: Int): Unit

  def glStencilOp(fail: Int, zfail: Int, zpass: Int): Unit

  def glStencilOpSeparate(face: Int, fail: Int, zfail: Int, zpass: Int): Unit

  def glTexImage2D(target: Int, level: Int, internalformat: Int,
                   width: Int, height: Int, border: Int, format: Int, tpe: Int, data: Buffer[_]): Unit

  def glTexParameteriv(target: Int, param: Int, value: Buffer[Int]): Unit

  def glTexParameterfv(target: Int, param: Int, value: Buffer[Float]): Unit

  def glTexSubImage2D(target: Int, level: Int, xoffset: Int, yoffset: Int,
                      width: Int, height: Int, format: Int, tpe: Int, data: Buffer[_]): Unit

  def glUniform1i(location: Int, x: Int): Unit
  def glUniform2i(location: Int, x: Int, y: Int): Unit
  def glUniform3i(location: Int, x: Int, y: Int, z: Int): Unit
  def glUniform4i(location: Int, x: Int, y: Int, z: Int, w: Int): Unit

  def glUniform1f(location: Int, x: Float): Unit
  def glUniform2f(location: Int, x: Float, y: Float): Unit
  def glUniform3f(location: Int, x: Float, y: Float, z: Float): Unit
  def glUniform4f(location: Int, x: Float, y: Float, z: Float, w: Float): Unit

  def glUniform1iv(location: Int, count: Int, buffer: Buffer[Int]): Unit
  def glUniform2iv(location: Int, count: Int, buffer: Buffer[Int]): Unit
  def glUniform3iv(location: Int, count: Int, buffer: Buffer[Int]): Unit
  def glUniform4iv(location: Int, count: Int, buffer: Buffer[Int]): Unit

  def glUniform1fv(location: Int, count: Int, buffer: Buffer[Float]): Unit
  def glUniform2fv(location: Int, count: Int, buffer: Buffer[Float]): Unit
  def glUniform3fv(location: Int, count: Int, buffer: Buffer[Float]): Unit
  def glUniform4fv(location: Int, count: Int, buffer: Buffer[Float]): Unit

  def glUniformMatrix2fv(location: Int, count: Int, transpose: Boolean, buffer: Buffer[Float]): Unit
  def glUniformMatrix3fv(location: Int, count: Int, transpose: Boolean, buffer: Buffer[Float]): Unit
  def glUniformMatrix4fv(location: Int, count: Int, transpose: Boolean, buffer: Buffer[Float]): Unit

  def glUseProgram(program: Int): Unit

  def glValidateProgram(program: Int): Unit

  def glVertexAttrib1f(index: Int, x: Float): Unit
  def glVertexAttrib2f(index: Int, x: Float, y: Float): Unit
  def glVertexAttrib3f(index: Int, x: Float, y: Float, z: Float): Unit
  def glVertexAttrib4f(index: Int, x: Float, y: Float, z: Float, w: Float): Unit

  def glVertexAttrib1fv(index: Int, buffer: Buffer[Float]): Unit
  def glVertexAttrib2fv(index: Int, buffer: Buffer[Float]): Unit
  def glVertexAttrib3fv(index: Int, buffer: Buffer[Float]): Unit
  def glVertexAttrib4fv(index: Int, buffer: Buffer[Float]): Unit

  def glVertexAttribPointer(index: Int, size: Int, tpe: Int, normalized: Boolean, stride: Int, offset: Int): Unit

  def glViewport(x: Int, y: Int, width: Int, height: Int): Unit
}
