package dk.w4.w4trails

import android.graphics.drawable.ClipDrawable.HORIZONTAL
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import dk.w4.w4trails.introduction.MainAdapter
import dk.w4.w4trails.utils.Constants
import kotlinx.android.synthetic.main.activity_main.*
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    val names = arrayOf(Constants.MAIN_ADAPTER_ROOM, "else", "then", "this")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainRecyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = MainAdapter(names)
        mainRecyclerView.adapter = adapter

        val itemDecor = DividerItemDecoration(this, HORIZONTAL)
        mainRecyclerView.addItemDecoration(itemDecor)
    }
}
