import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.ViewModel

object TestViewModel : ViewModel() {
    data class Status(
        val switch: SimpleBooleanProperty = SimpleBooleanProperty(false),
        val msg: SimpleStringProperty = SimpleStringProperty("")
    )

    val numSwitches: Int
        get() = 3

    val switches = ArrayList<Status>()

    init {
        resetSwitches()
    }

    fun updateStatus(num: Int, message: String) {
        with(switches[num]) {
            switch.value = true
            msg.value = message
        }
    }

    private fun resetSwitches() {
        switches.clear()
        repeat(numSwitches) {
            switches.add(Status())
        }
    }
}