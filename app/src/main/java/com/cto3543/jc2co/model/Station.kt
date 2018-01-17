package com.cto3543.jc2co.model

import android.os.Parcel
import android.os.Parcelable

/**
 * {"number":152,
 * "name":"00152 - MAZADES",
 * "address":"10 AV DES MAZADES",
 * "position":{"lat":43.624183134252704,"lng":1.438302180907754},
 * "banking":true,
 * "bonus":false,
 * "status":"OPEN",
 * "contract_name":"Toulouse",
 * "bike_stands":20,
 * "available_bike_stands":8,
 * "available_bikes":12,
 * "last_update":1516054055000}
 * */
data class Station(val number: Int = -1,
                   val name: String = "",
                   val address: String = "",
                   val position: Location,
                   val banking: Boolean = false,
                   val bonus: Boolean = false,
                   val status: String = "",
                   val contract_name: String = "",
                   val bike_stands: Int = 0,
                   val available_bike_stands: Int = 0,
                   val available_bikes: Int = 0,
                   val last_update: Double = 0.0
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readParcelable(Location::class.java.classLoader),
            parcel.readByte() != 0.toByte(),
            parcel.readByte() != 0.toByte(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readDouble())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(number)
        parcel.writeString(name)
        parcel.writeString(address)
        parcel.writeParcelable(position, flags)
        parcel.writeByte(if (banking) 1 else 0)
        parcel.writeByte(if (bonus) 1 else 0)
        parcel.writeString(status)
        parcel.writeString(contract_name)
        parcel.writeInt(bike_stands)
        parcel.writeInt(available_bike_stands)
        parcel.writeInt(available_bikes)
        parcel.writeDouble(last_update)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Station> {
        override fun createFromParcel(parcel: Parcel): Station {
            return Station(parcel)
        }

        override fun newArray(size: Int): Array<Station?> {
            return arrayOfNulls(size)
        }
    }
}

data class Location(val lat: Double? = 0.0,
                    val lng: Double? = 0.0) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readValue(Double::class.java.classLoader) as? Double,
            parcel.readValue(Double::class.java.classLoader) as? Double)

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(lat)
        parcel.writeValue(lng)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Location> {
        override fun createFromParcel(parcel: Parcel): Location {
            return Location(parcel)
        }

        override fun newArray(size: Int): Array<Location?> {
            return arrayOfNulls(size)
        }
    }
}