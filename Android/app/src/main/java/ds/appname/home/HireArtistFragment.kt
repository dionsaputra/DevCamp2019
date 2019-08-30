package ds.appname.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ds.appname.R
import ds.appname.common.RoundedBottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_sheet_hire_artist.*

class HireArtistFragment : RoundedBottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet_hire_artist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        messageSentButton.setOnClickListener {
            MessageSentDialogFragment().show(
                childFragmentManager,
                MessageSentDialogFragment::class.java.simpleName
            )
        }
    }
}