package dk.w4.w4trails.room

import android.graphics.drawable.ClipDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dk.w4.w4trails.R
import dk.w4.w4trails.room.entry.Clue
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_room.*
import kotlinx.android.synthetic.main.clue_item.*

class RoomActivity : AppCompatActivity() {

    lateinit var viewModel: RoomViewModel
    val adapter = ClueAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        val clueRepository = ClueRepository(this)
        viewModel = RoomViewModel(clueRepository)

        viewModel.observeClues().observe(this, Observer { clues ->
            adapter.updateItems(clues)
        })

        rvClues.layoutManager = LinearLayoutManager(this)
        rvClues.adapter = adapter


        btnInsert.setOnClickListener {
            val name = etName.text.toString()
            val info = etInfo.text.toString()

            val clue = Clue(0, name, info)
            viewModel.applyClue(clue)
        }

        val itemDecor = DividerItemDecoration(this, ClipDrawable.HORIZONTAL)
        rvClues.addItemDecoration(itemDecor)
    }
}
