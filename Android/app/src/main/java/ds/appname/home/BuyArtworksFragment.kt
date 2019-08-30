package ds.appname.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ds.appname.R
import ds.appname.common.RoundedBottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_sheet_buy_artworks.*

class BuyArtworksFragment : RoundedBottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet_buy_artworks, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        orderButton.setOnClickListener {
            OrderFinishDialogFragment().show(
                childFragmentManager,
                OrderFinishDialogFragment::class.java.simpleName
            )
        }
    }

}