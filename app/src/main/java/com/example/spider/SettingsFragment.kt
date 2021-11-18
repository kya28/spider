package com.example.spider

import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupMenu
import java.util.*

class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_settings, container, false)
        val buttonSelectedLanguage : Button = view.findViewById(R.id.button_selected_language)
        buttonSelectedLanguage.setOnClickListener {
            showPopup(view)
        }
        return view
    }
    private fun showPopup(view: View) {
        val popup = PopupMenu(context, view)
        popup.inflate(R.menu.popup_language_menu)

        popup.setOnMenuItemClickListener { item: MenuItem? ->
            when (item!!.itemId) {
                R.id.english -> {
                    setLocalLang("en")
                }
                R.id.ru -> {
                    setLocalLang("ru")
                }
            }
            true
        }

        popup.show()
    }
    private fun setLocalLang(localeCode: String){
        val locale = Locale(localeCode)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        resources.updateConfiguration(config, resources.displayMetrics)
        val intent = Intent(context, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
    }
}