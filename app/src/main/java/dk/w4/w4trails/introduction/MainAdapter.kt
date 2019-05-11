package dk.w4.w4trails.introduction

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dk.w4.w4trails.R
import dk.w4.w4trails.room.RoomActivity
import dk.w4.w4trails.utils.Constants
import kotlinx.android.synthetic.main.mainadapterlayout.view.*

class MainAdapter(private val values: Array<String>) : RecyclerView.Adapter<MainAdapter.SimpleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.mainadapterlayout, parent, false)
        return SimpleViewHolder(parent.context, view)
    }

    override fun getItemCount(): Int {
        return values.size
    }

    override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {
        val name = values[position]
        holder.view.tvMainAdapterLayout.text = name
    }


    class SimpleViewHolder(val context: Context, val view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        init {
            view.setOnClickListener(this)
        }


        override fun onClick(p0: View?) {
            when (p0?.tvMainAdapterLayout?.text.toString()) {
                Constants.MAIN_ADAPTER_ROOM -> {
                    val intent = Intent(context, RoomActivity::class.java)
                    context.startActivity(intent)
                }
            }

        }

    }
}