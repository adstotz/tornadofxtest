
import javafx.geometry.Pos
import javafx.scene.layout.BackgroundPosition
import javafx.scene.layout.BackgroundRepeat
import javafx.scene.layout.BackgroundSize
import javafx.scene.paint.Color
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import javafx.scene.text.TextAlignment
import tornadofx.*

class UIAppStyle : Stylesheet() {
    companion object {
        val smiling_grid_pane by cssclass()
        val smiling_cell by cssclass()
        val base_cell by cssclass()
    }

    init {
        s(smiling_grid_pane) {
            fontSize = 25.px
            textFill = Color.GHOSTWHITE
            backgroundColor += c(Color.BLACK.toString(), .5)
            prefWidth = infinity
            maxHeight = 100.px
        }
        s(smiling_cell) {
            backgroundImage += this::class.java.classLoader.getResource("smiley.jpg")!!.toURI()
            backgroundPosition += BackgroundPosition.CENTER
            backgroundRepeat += Pair(BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT)
            backgroundSize += BackgroundSize(100.0, 100.0, true, true, true, true)
        }
        s(base_cell) {
            maxWidth = infinity
            maxHeight = infinity
            alignment = Pos.CENTER
        }
    }
}