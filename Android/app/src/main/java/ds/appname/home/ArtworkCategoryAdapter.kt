package ds.appname.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ds.appname.R
import ds.appname.common.load
import ds.appname.model.ArtCategory
import kotlinx.android.synthetic.main.item_artwork_category.view.*

class ArtworkCategoryAdapter(
    private var data: List<ArtCategory>,
    private var onItemClick: ArtCategorySelectedListener
) : RecyclerView.Adapter<ArtworkCategoryAdapter.ArtCategoryHolder>() {

    private val itemLayout = R.layout.item_artwork_category

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtCategoryHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ArtCategoryHolder(
            inflater.inflate(
                itemLayout,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ArtCategoryHolder, position: Int) {
        holder.bind(data[position], onItemClick)
    }

    fun swapData(data: List<ArtCategory>) {
        this.data = data
        notifyDataSetChanged()
    }

    class ArtCategoryHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: ArtCategory, onItemClick: ArtCategorySelectedListener) = with(itemView) {
            title.text = item.category
            firstArt.load(item.firstArt)
            secondArt.load(item.secondArt)
            thirdArt.load(item.thirdArt)
            firstArt.setOnClickListener { onItemClick.onDirectItemClick() }
            secondArt.setOnClickListener { onItemClick.onDirectItemClick() }
            thirdArt.setOnClickListener { onItemClick.onMoreItemClick() }
        }

    }

    interface ArtCategorySelectedListener {
        fun onDirectItemClick()
        fun onMoreItemClick()
    }
}