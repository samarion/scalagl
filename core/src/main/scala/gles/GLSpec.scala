package gles

trait GLSpec {

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

  def glBufferData(target: Int, size: Int, data: Any, usage: Int): Unit

  def glBufferSubData(target: Int, offset: Int, size: Int, data: Any): Unit

  def glCheckFramebufferStatus(target: Int): Int

  def glClear(mask: Int): Unit

  def glClearColor(red: Float, green: Float, blue: Float, alpha: Float): Unit

  def glClearDepthf(depth: Float): Unit

  def glClearStencil(s: Int): Unit

  def glColorMask(red: Boolean, green: Boolean, blue: Boolean, alpha: Boolean): Unit

  def glCompileShader(shader: Int): Unit

  def glCompressedTexImage2D(target: Int, level: Int, format: Int,
                             width: Int, height: Int, border: Int, imageSize: Int, data: Any): Unit

  def glCompressedTexSubImage2D(target: Int, level: Int, xoffset: Int, yoffset: Int,
                                width: Int, height: Int, format: Int, imageSize: Int, data: Any): Unit

  def glCopyTexImage2D(target: Int, level: Int, format: Int, x: Int, y: Int,
                       width: Int, height: Int, border: Int): Unit

  def glCopyTexSubImage2D(target: Int, level: Int, xoffset: Int, yoffset: Int, x: Int, y: Int,
                          width: Int, height: Int): Unit

  def glCreateProgram(): Int

  def glCreateShader(shaderType: Int): Int

  def glCullFace(mode: Int): Unit

  def glDeleteBuffers(buffers: Array[Int]): Unit

  def glDeleteFramebuffers(buffers: Array[Int]): Unit

  def glDeleteProgram(program: Int): Unit

  def glDeleteRenderbuffers(buffers: Array[Int]): Unit

  def glDeleteShader(shader: Int): Unit

  def glDeleteTextures(textures: Array[Int]): Unit

  def glDepthFunc(func: Int): Unit

  def glDepthMask(flag: Boolean): Unit

  def glDepthRangef(near: Float, far: Float): Unit

  def glDetachShader(program: Int, shader: Int): Unit

  def glDisable(cap: Int): Unit

  def glDisableVertexAttribArray(index: Int): Unit

  def glDrawArrays(mode: Int, first: Int, count: Int): Unit

  def glDrawElements(mode: Int, count: Int, tpe: Int, indices: Any): Unit

  def glEnable(cap: Int): Unit

  def glEnableVertexAttribArray(index: Int): Unit

  def glFinish(): Unit

  def glFlush(): Unit

  def glFramebufferRenderbuffer(target: Int, attachment: Int, buffertarget: Int, buffer: Int): Unit

  def glFramebufferTexture2D(target: Int, attachment: Int, textarget: Int, texture: Int, level: Int): Unit

  def glFrontFace(mode: Int): Unit

  def glGenBuffers(n: Int): Array[Int]

  def glGenFramebuffers(n: Int): Array[Int]

  def glGenRenderbuffers(n: Int): Array[Int]

  def glGenTextures(n: Int): Array[Int]

  def glGenerateMipmap(target: Int): Unit

  def glGetInt(pname: Int): Int

  def glGetFloat(pname: Int): Float

  def glGetActiveAttrib(program: Int, index: Int, bufSize: Int): (Int, Int, String)

  def glGetActiveUniform(program: int, index: Int, bufSize: Int): (Int, Int, String)

  def glGetAttachedShaders(program: Int, maxCount: Int): Array[Int]

  def glGetAttribLocation(program: Int, name: String): Int

  def glGetBufferParameteriv(target: Int, value: Int): Int

  def glGetError(): Int

  def glGetFramebufferAttachmentParameteriv(target: Int, attachment: Int, pname: Int): int

  def glGetProgramInfoLog(program: Int, maxLength: Int): String

  def glGetProgramiv(program: Int, pname: Int): Int

  def glGetRenderbufferParameteriv(target: Int, pname: Int): Int

  def glGetShaderInfoLog(shader: Int, maxLength: Int): String

  def glGetShaderPrecisionFormat(shaderType: Int, precisionType: Int): (Int, Int, Int)

  def glGetShaderSource(shader: Int, bufSize: Int): String

  def glGetShaderiv(shader: Int, pname: Int): Int

  def glGetString(name: Int): String

  def glGetTexParameterInt(target: Int, pname: Int): Int

  def glGetTexParameterFloat(target: Int, pname: Int): Float

  def glGetUniformInt(program: Int, location: Int): Int

  def glGetUniformFloat(program: Int, location: Int): Float

  def glGetUniformLocation(program: Int, name: String): Int

  def glGetVertexAttribInt(index: Int, pname: Int): Float

  def glGetVertexAttribFloat(index: Int, pname: Int): Float

  /*
  void glGetVertexAttribPointerv(GLuint index,
      GLenum pname,
        GLvoid **pointer);
  */

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

  def glPixelStore(param: Int, value: Int): Unit

  def glPolygonOffset(factor: Float, units: Float): Unit

  def glReadPixels(x: Int, y: Int, width: Int, height: Int, format: Int, tpe: Int): Any

  def glReleaseShaderCompiler(): Unit

  def glRenderbufferStorage(target: Int, format: Int, width: Int, height: Int): Unit

  def glSampleCoverage(value: Float, invert: Boolean): Unit

  def glScissor(x: Int, y: Int, width: Int, height: Int): Unit

  def glShaderBinary(format: Int, data: Array[Byte]): Array[Int]

  def glShaderSource(shader: Int, source: Array[String]): Unit

  def glStencilFunc(func: Int, ref: Int, mask: Int): Unit

  def glStencilFuncSeparate(face: Int, func: Int, ref: Int, mask: Int): Unit

  def glStencilMask(mask: Int): Unit

  def glStencilMaskSeparate(face: Int, mask: Int): Unit

  def glStencilOp(sfail: Int, dpfail: Int, dppass: Int): Unit

  def glStencilOpSeparate(face: Int, sfail: Int, dpfail: Int, dppass: Int): Unit

  def glTexImage2D(target: Int, level: Int, internalformat: Int,
                   width: Int, height: Int, border: Int, format: Int, tpe: Int, data: Any): Unit

  def glTexParameter(target: Int, param: Int, value: Any): Unit

  def glTexSubImage2D(target: Int, level: Int, xoffset: Int, yoffset: Int,
                      width: Int, height: Int, format: Int, tpe: Int, data: Any): Unit

  def glUniform(location: Int, value: Any): Unit

  def glUseProgram(program: Int): Unit

  def glValidateProgram(program: Int): Unit

  def glVertexAttrib(index: Int, value: Any): Unit

  /*
void glVertexAttribPointer(GLuint index,
    GLint size,
      GLenum type,
        GLboolean normalized,
          GLsizei stride,
            const GLvoid * pointer);
            */

  def glViewport(x: Int, y: Int, width: Int, height: Int): Unit
}
