import javafx.scene.layout.ColumnConstraints
import javafx.scene.layout.Priority
import javafx.scene.layout.RowConstraints
import mu.KotlinLogging
import tornadofx.*

class TestView : View() {
    //private val logger = KotlinLogging.logger { } //when this is uncommented, it no longer works
    private var switchCounter = 0
    private val vm = TestViewModel

    override val root = vbox {
        gridpane {
            addClass(UIAppStyle.smiling_grid_pane)
            prefHeight = 200.0

            val numSwitches = vm.numSwitches

            //setup grid pane
            val colConstraints = ColumnConstraints()
            colConstraints.percentWidth = 100.0 / numSwitches
            colConstraints.hgrow = Priority.ALWAYS
            colConstraints.isFillWidth = true

            repeat(numSwitches) {
                this.columnConstraints.add(colConstraints)
            }

            val rowConstraints = RowConstraints()
            rowConstraints.vgrow = Priority.ALWAYS
            rowConstraints.isFillHeight = true

            this.rowConstraints.addAll(rowConstraints)

            row {
                repeat(numSwitches) {
                    val status = vm.switches[it]
                    label(status.msg) {
                        addClass(UIAppStyle.base_cell)
                        toggleClass(UIAppStyle.smiling_cell, status.switch.not())
                    }
                }
            }
        }
        button("Update Switch") {
            action {
                vm.updateStatus(switchCounter, "Pressed")
                switchCounter++
            }
        }
    }
}