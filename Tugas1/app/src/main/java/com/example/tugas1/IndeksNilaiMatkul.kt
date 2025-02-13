package com.example.tugas1

class IndeksNilaiMatkul {
    fun hitungIndeks(nilai: Int): String {
        return when {
            nilai > 100 -> "Nilai diluar jangkauan"
            nilai in 80..100 -> "A"
            nilai in 70..79 -> "AB"
            nilai in 60..69 -> "B"
            nilai in 50..59 -> "BC"
            nilai in 40..49 -> "C"
            nilai in 30..39 -> "D"
            nilai in 0..29 -> "E"
            else -> "Nilai tidak valid"
        }
    }
}

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Nilai harus di isi")
        return
    }

    val nilaiAkhir = args[0].toIntOrNull()
    if (nilaiAkhir == null) {
        println("Harap masukkan angka yang valid.")
        return
    }

    val indeksNilaiMatkul = IndeksNilaiMatkul()
    val indeks = indeksNilaiMatkul.hitungIndeks(nilaiAkhir)
    println("Nilai akhir: $nilaiAkhir - Indeks: $indeks")
}