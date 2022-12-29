package com.example.obstetricscalculator

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.obstetricscalculator.databinding.ContentMainBinding

class MainContent : Fragment() {
    private var binding: ContentMainBinding? = null
    private var tabAdapter: TabAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        viewGroup: ViewGroup?,
        bundle: Bundle?
    ): View {
        val inflate = DataBindingUtil.inflate<ViewDataBinding>(
            inflater,
            R.layout.content_main,
            viewGroup,
            false
        )

        val contentMainBinding: ContentMainBinding = inflate as ContentMainBinding
        binding = contentMainBinding
        return contentMainBinding.root
    }

    override fun onViewCreated(view: View, bundle: Bundle?) {
        super.onViewCreated(view, bundle)
        setHasOptionsMenu(true)
        var contentMainBinding = binding
        val viewPager2 = contentMainBinding!!.viewPager
        val tabAdapter = TabAdapter(this)
        this.tabAdapter = tabAdapter
        viewPager2.currentItem = selectedTabPosition
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.changeTheme) {
            val activity = activity
            Utils.changeTheme(activity as MainActivity?)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        private var selectedTabPosition = 0
    }
}