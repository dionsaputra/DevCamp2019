package ds.appname.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ds.appname.R

class ArtCategoryAdapter(
    private var data: List<String>,
    private var onItemClick: ArtCategorySelectedListener
) : RecyclerView.Adapter<ArtCategoryAdapter.ArtCategoryHolder>() {

    private val itemLayout = R.layout.item_art_category

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtCategoryHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ArtCategoryHolder(inflater.inflate(itemLayout, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ArtCategoryHolder, position: Int) {
        holder.bind(data[position], onItemClick)
    }

    fun swapData(data: List<String>) {
        this.data = data
        notifyDataSetChanged()
    }

    class ArtCategoryHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: String, onItemClick: ArtCategorySelectedListener) = with(itemView) {
            // TODO: bind model to itemView            

        }

    }

    interface ArtCategorySelectedListener {
        fun onDirectItemClick()
        fun onMoreItemClick()
    }
}