package dk.w4.w4trails.room

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dk.w4.w4trails.R
import dk.w4.w4trails.room.entry.Clue
import kotlinx.android.synthetic.main.clue_item.view.*

class ClueAdapter : RecyclerView.Adapter<ClueAdapter.ClueViewHolder>() {

    private var items = listOf<Clue>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClueViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.clue_item, parent, false)
        return ClueViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ClueViewHolder, position: Int) {
        val item = items[position]
        holder.view.tvName.text = item.name
        holder.view.tvInfo.text = item.info
    }

    fun updateItems(items: List<Clue>){
        this.items = items
        notifyDataSetChanged()
    }


    class ClueViewHolder(val view: View) : RecyclerView.ViewHolder(view)

}