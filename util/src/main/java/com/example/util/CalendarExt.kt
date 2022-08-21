package com.example.util

import com.example.util.Const.LocaleConst.LOCALE_COUNTRY_BR
import com.example.util.Const.LocaleConst.LOCALE_PT
import java.util.Locale

val LOCAL_DEFAULT: Locale by lazy {
    Locale(LOCALE_PT, LOCALE_COUNTRY_BR)
}
