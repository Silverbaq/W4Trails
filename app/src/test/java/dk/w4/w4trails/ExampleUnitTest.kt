package dk.w4.w4trails

import android.content.Context
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner


private const val FAKE_STRING = "HELLO WORLD"

@RunWith(MockitoJUnitRunner::class)
class UnitTestSample {

    @Mock
    private lateinit var mockContext: Context

    @Test
    fun readStringFromContext_LocalizedString() {
        // Given a mocked Context injected into the object under test...
        `when`(mockContext.getString(R.string.hello_world))
            .thenReturn(FAKE_STRING)
        val myObjectUnderTest = ClassUnderTest(mockContext)

        // ...when the string is returned from the object under test...
        val result: String = myObjectUnderTest.getHelloWorldString()

        // ...then the result should be the expected one.
        MatcherAssert.assertThat(result, CoreMatchers.`is`(FAKE_STRING))

    }
}


class ClassUnderTest(val context: Context) {
    fun getHelloWorldString(): String {
        return context.getString(R.string.hello_world)
    }

}
