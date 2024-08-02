package com.app.friendschat.data.local

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import javax.inject.Inject

class PreferencesHelper @Inject constructor(context: Context, prefFileName: String) :
    IPreferenceHelper {

    companion object {
        private const val MASTER_KEY_ALIAS = "Base_ALIAS"
        private const val KEY_SIZE = 256

        const val TOKEN_KEY = "token"
        const val JSON_UNDO_LIST = "json undo list"
    }

    private var masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

    private var sharedPreferences = EncryptedSharedPreferences.create(
        prefFileName,
        masterKeyAlias,
        context,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )


    override var token: String
        get() = sharedPreferences.getString(TOKEN_KEY, "")!!
        set(value) {
            sharedPreferences.edit().apply {
                putString(TOKEN_KEY, value)
            }.apply()
        }
    override var jsonUndoList: String?
        get() = sharedPreferences.getString(JSON_UNDO_LIST, "")
        set(value) {
            sharedPreferences.edit().apply {
                putString(JSON_UNDO_LIST, value)
            }.apply()
        }
}