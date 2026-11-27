package com.feroz.aitrader

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.*

class MainActivity : Activity() {
    private val gold = Color.rgb(222, 176, 70)
    private val bg = Color.rgb(12, 13, 17)
    private lateinit var result: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val root = LinearLayout(this).apply { orientation = 1; setPadding(24, 34, 24, 24); setBackgroundColor(bg) }
        fun label(text: String, size: Float, color: Int = Color.WHITE) = TextView(this).apply {
            this.text = text; textSize = size; setTextColor(color); gravity = Gravity.CENTER
            setPadding(8, 12, 8, 12)
        }
        root.addView(label("FEROZ AI TRADER", 27f, gold))
        root.addView(label("XAUUSD  •  DEMO ANALYSIS", 14f, Color.LTGRAY))
        root.addView(label("Smart market checklist", 19f, gold))
        root.addView(label("This starter app does not connect to MT5 or receive live prices. Use demo data only.", 13f, Color.LTGRAY))
        val info = label("Market: WAITING\nTrend: Not evaluated\nRisk: Demo only", 18f)
        root.addView(info)
        val analyze = Button(this).apply { text = "RUN DEMO ANALYSIS"; setTextColor(Color.BLACK); setBackgroundColor(gold) }
        root.addView(analyze)
        result = label("No trade signal yet. Press the button to inspect sample data.", 16f)
        root.addView(result)
        root.addView(label("Risk rule: never risk money based on an unverified signal. No order is placed by this app.", 12f, Color.LTGRAY))
        analyze.setOnClickListener {
            // Deterministic sample only: intentionally not represented as live market data.
            result.text = "SAMPLE RESULT\nSignal: WAIT\nReason: No verified live candles connected\nEntry / SL / TP: Not available\nMode: Offline demo"
        }
        setContentView(ScrollView(this).apply { addView(root) })
    }
}
