package ds.appname.order

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ds.appname.R
import ds.appname.model.Order
import kotlinx.android.synthetic.main.item_order.view.*
import java.text.SimpleDateFormat


class OrderAdapter(
    private var data: List<Order>,
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

    fun swapData(data: List<Order>) {
        this.data = data
        notifyDataSetChanged()
    }

    class OrderHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @SuppressLint("SetTextI18n")
        fun bind(item: Order, onItemClick: ((String) -> Unit)?) = with(itemView) {
            orderId.text = "Order #${item.orderId}"

            val simpleDate = SimpleDateFormat("dd/MM/yyyy HH:mm")
            dateTme.text = simpleDate.format(item.dateTime)

            address.text = item.customerAddress
        }

    }
}