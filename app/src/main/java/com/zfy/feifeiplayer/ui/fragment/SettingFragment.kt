package com.zfy.feifeiplayer.ui.fragment

import android.os.Bundle
import android.preference.PreferenceFragment
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zfy.feifeiplayer.R
import com.zfy.feifeiplayer.util.ToolbarManager
import org.jetbrains.anko.find

/**
 *
 */
class SettingFragment:PreferenceFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        addPreferencesFromResource(R.xml.frag_setting)
        return super.onCreateView(inflater, container, savedInstanceState)

    }

}