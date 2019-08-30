package ds.appname.order

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.vipulasri.timelineview.TimelineView
import ds.appname.R
import kotlinx.android.synthetic.main.item_timeline.view.*

class OrderStatusAdapter(
    private var data: List<String>
) : RecyclerView.Adapter<OrderStatusAdapter.OrderStatusHolder>() {

    private val itemLayout = R.layout.item_timeline

    override fun getItemViewType(position: Int): Int {
        return TimelineView.getTimeLineViewType(position, itemCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderStatusHolder {
        val inflater = LayoutInflater.from(parent.context)
        return OrderStatusHolder(inflater.inflate(itemLayout, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: OrderStatusHolder, position: Int) {
        holder.bind(data[position])
    }

    fun swapData(data: List<String>) {
        this.data = data
        notifyDataSetChanged()
    }

    class OrderStatusHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.orderStatusTimeline.initLine(itemViewType)
        }

        fun bind(item: String) = with(itemView) {
            // TODO: bind model to itemView
        }

    }
}