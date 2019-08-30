package ds.appname.order

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ds.appname.R
import kotlinx.android.synthetic.main.item_order.view.*

class OrderAdapter(
    private var data: List<String>,
    private val onItemClick: ((String) -> Unit)? = null
) : RecyclerView.Adapter<OrderAdapter.OrderHolder>() {

    private val itemLayout = R.layout.item_order

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderHolder {
        val inflater = LayoutInflater.from(parent.context)
        return OrderHolder(inflater.inflate(itemLayout, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: OrderHolder, position: Int) {
        holder.bind(data[position], onItemClick)
    }

    fun swapData(data: List<String>) {
        this.data = data
        notifyDataSetChanged()
    }

    class OrderHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val orderStatusAdapter = OrderStatusAdapter(listOf("a", "b", "c"))

        fun bind(item: String, onItemClick: ((String) -> Unit)?) = with(itemView) {
            statusRecycler.apply {
                adapter = orderStatusAdapter
                layoutManager = LinearLayoutManager(itemView.context)
            }
        }

    }
}