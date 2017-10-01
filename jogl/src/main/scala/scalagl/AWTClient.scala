package scalagl

import com.jogamp.opengl._
import com.jogamp.opengl.awt._

object AWTClient {
  def register(mkRenderer: gl.GLES2 => Renderer): java.awt.Canvas = {
    val profile = GLProfile.getDefault()
    val capabilities = new GLCapabilities(profile)
    val canvas = new GLCanvas(capabilities)

    // We create an empty JOGLES2 instance here, but never expose it to the client.
    // The instance is only made accessible once its `gl` field has been populated.
    val jogl = new gl.JOGLES2(null)
    var renderer: Renderer = null

    // This is used for sanity checks. In our setting, the GLAutoDrawable instance
    // should never change once init has been called.
    var currentAutoDrawable: GLAutoDrawable = null

    canvas.addGLEventListener(new GLEventListener {
      override def init(drawable: GLAutoDrawable): Unit = {
        jogl.gl = drawable.getGL.getGLES2
        currentAutoDrawable = drawable
        renderer = mkRenderer(jogl)
      }

      override def reshape(drawable: GLAutoDrawable, x: Int, y: Int, width: Int, height: Int): Unit = {
        assert(currentAutoDrawable eq drawable, "GLAutoDrawable instance should never change")
        renderer.reshape(x, y, width, height)
      }

      override def dispose(drawable: GLAutoDrawable): Unit = {
        assert(currentAutoDrawable eq drawable, "GLAutoDrawable instance should never change")
        renderer.dispose()
      }

      override def display(drawable: GLAutoDrawable): Unit = {
        assert(currentAutoDrawable eq drawable, "GLAutoDrawable instance should never change")
        renderer.display()
      }
    })

    canvas
  }
}
