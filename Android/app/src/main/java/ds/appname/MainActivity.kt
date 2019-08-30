package ds.appname

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ds.appname.adapter.MainPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainPagerAdapter: MainPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupMainPagerAdapter()
        setupMainBottomNavigation()
    }

    private fun setupMainPagerAdapter() {
        mainPagerAdapter = MainPagerAdapter(supportFragmentManager)
        mainViewPager.adapter = mainPagerAdapter
    }

    private fun setupMainBottomNavigation() {
        mainBottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> mainViewPager.currentItem = HOME_POSITION
            }
            true
        }

        mainBottomNav.selectedItemId = R.id.home
    }

    companion object {
        private const val HOME_POSITION = 0
    }
}
