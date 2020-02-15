package com.alvinhkh.buseta.ui.webview

import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.alvinhkh.buseta.R


class WebViewFragment : Fragment() {

    private lateinit var actionBar: ActionBar

    private lateinit var webView: WebView

    private var contentTitle: String? = null

    private var contentHtml: String? = null

    private var upEnabled: Boolean = true


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_webview, container, false)
        contentTitle = arguments?.getString(ARG_TITLE)
        contentHtml = arguments?.getString(ARG_HTML)
        upEnabled = arguments?.getBoolean(ARG_UP_ENABLED)?: true
        if (activity == null) return view

        actionBar = (activity as AppCompatActivity).supportActionBar!!
        actionBar.title = contentTitle
        actionBar.subtitle = null
        actionBar.setDisplayHomeAsUpEnabled(upEnabled)
        setHasOptionsMenu(false)

        webView = view.findViewById(R.id.web_view)
        webView.loadData(contentHtml, "text/html; charset=UTF-8", null)
        webView.settings.loadWithOverviewMode = true
        webView.settings.useWideViewPort = true
        if (Build.VERSION.SDK_INT >= 29) {
            val nightModeFlags = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
            if (nightModeFlags == Configuration.UI_MODE_NIGHT_YES) {
                webView.settings.forceDark = WebSettings.FORCE_DARK_ON
            }
        }
        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(ARG_TITLE, contentTitle)
        outState.putString(ARG_HTML, contentHtml)
        outState.putBoolean(ARG_UP_ENABLED, upEnabled)
    }

    override fun onResume() {
        super.onResume()
        actionBar.title = contentTitle
        actionBar.subtitle = null
    }

    override fun onDestroyView() {
        view?.visibility = View.GONE
        super.onDestroyView()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_refresh) {
            webView.loadData(contentHtml, "text/html; charset=UTF-8", null)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {

        const val ARG_TITLE = "content_title"

        const val ARG_HTML = "content_html"

        const val ARG_UP_ENABLED = "up_enabled"

        fun newInstance(title: String, html: String, upEnabled: Boolean): WebViewFragment {
            val fragment = WebViewFragment()
            val args = Bundle()
            args.putString(ARG_TITLE, title)
            args.putString(ARG_HTML, html)
            args.putBoolean(ARG_UP_ENABLED, upEnabled)
            fragment.arguments = args
            return fragment
        }
    }

}