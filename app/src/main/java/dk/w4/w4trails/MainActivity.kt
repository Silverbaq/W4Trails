package dk.w4.w4trails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import dk.w4.w4trails.introduction.MainAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val names = arrayOf("something", "else", "then", "this")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainRecyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = MainAdapter(names)
        mainRecyclerView.adapter = adapter
    }
}
