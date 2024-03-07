package codes.app007

import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.text.NumberFormat

class CalculateTests {
    @Test
    fun calculate_20PercentOf10WithoutRoundUp() {
        val amount = 10.00
        val percent = 20.00
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        val actualTip = calculate(amount, percent, false)
        assertEquals(expectedTip, actualTip)
    }
}