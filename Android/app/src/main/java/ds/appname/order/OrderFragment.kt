package ds.appname.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ds.appname.R
import kotlinx.android.synthetic.main.fragment_order.*

class OrderFragment : Fragment() {

    private lateinit var orderAdapter: OrderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_order, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupOrderAdapter()
    }

    private fun setupOrderAdapter() {
        orderAdapter = OrderAdapter(listOf("a", "b", "c"))
        orderRecycler.apply {
            adapter = orderAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    companion object {
        fun newInstance() = OrderFragment()
    }

}
