package ds.appname.order

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ds.appname.R
import ds.appname.repository.AppRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_order.*

class OrderFragment : Fragment() {

    private lateinit var orderAdapter: OrderAdapter
    private val appRepo = AppRepo()

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

    @SuppressLint("CheckResult")
    private fun setupOrderAdapter() {
        orderAdapter = OrderAdapter(emptyList())
        orderRecycler.apply {
            adapter = orderAdapter
            layoutManager = LinearLayoutManager(context)
        }
        appRepo.listOrder()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { showLoading() }
            .doAfterTerminate { stopLoading() }
            .subscribe({
                orderAdapter.swapData(it)
            }, {
                Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
            })
    }

    private fun showLoading() {
        orderProgress.visibility = View.VISIBLE
        orderRecycler.visibility = View.GONE
    }

    private fun stopLoading() {
        orderProgress.visibility = View.GONE
        orderRecycler.visibility = View.VISIBLE
    }

    companion object {
        fun newInstance() = OrderFragment()
    }

}
