package dk.w4.w4trails.introduction

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dk.w4.w4trails.R
import kotlinx.android.synthetic.main.mainadapterlayout.view.*

class MainAdapter(private val values: Array<String>) : RecyclerView.Adapter<MainAdapter.SimpleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.mainadapterlayout, parent, false)
        return SimpleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return values.size
    }

    override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {
        val name = values[position]
        holder.view.tvMainAdapterLayout.text = name
    }


    class SimpleViewHolder(val view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        override fun onClick(p0: View?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }
}