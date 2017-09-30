package scalagl

abstract class Renderer(final val gl: scalagl.gl.GLES2) {
  /** Called during the first repaint after the GL component has been resized.
    * The input arguments correspond to calling `glViewport(x, y, width, height)`. */
  def reshape(x: Int, y: Int, width: Int, height: Int): Unit

  /** Called when the associated GL context is being destroyed.
    * All allocated resources such as memory buffers and programs should be
    * released here. */
  def dispose(): Unit

  /** Perform OpenGL rendering. */
  def display(): Unit
}
