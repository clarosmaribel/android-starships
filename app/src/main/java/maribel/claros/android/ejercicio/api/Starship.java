package maribel.claros.android.ejercicio.api;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Starship implements Parcelable {

    public Starship() {}

    public Starship(String name, String model, String starshipClass, String manufacturer, String length, String crew, String passengers, String capacity, String consumables) {
        this.name = name;
        this.model = model;
        this.starshipClass = starshipClass;
        this.manufacturer = manufacturer;
        this.length = length;
        this.crew = crew;
        this.passengers = passengers;
        this.capacity = capacity;
        this.consumables = consumables;

    }

    protected Starship(Parcel in) {
        name = in.readString();
        model = in.readString();
        starshipClass = in.readString();
        manufacturer = in.readString();
        length = in.readString();
        crew = in.readString();
        passengers = in.readString();
        capacity = in.readString();
        consumables = in.readString();

    }

    @SerializedName("name")
    private String name;

    @SerializedName("model")
    private String model;

    @SerializedName("starship_class")
    private String starshipClass;

    @SerializedName("manufacturer")
    private String manufacturer;

    @SerializedName("length")
    private String length;

    @SerializedName("crew")
    private String crew;

    @SerializedName("passengers")
    private String passengers;

    @SerializedName("cargo_capacity")
    private String capacity;

    @SerializedName("consumables")
    private String consumables;

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getStarshipClass() {
        return starshipClass;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getLength() {
        return length;
    }

    public String getCrew() {
        return crew;
    }

    public String getPassengers() {
        return passengers;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getConsumables() {
        return consumables;
    }

    public static final Creator<Starship> CREATOR = new Creator<Starship>() {
        @Override
        public Starship createFromParcel(Parcel in) {
            return new Starship(in);
        }

        @Override
        public Starship[] newArray(int size) {
            return new Starship[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(model);
        dest.writeString(starshipClass);
        dest.writeString(manufacturer);
        dest.writeString(length);
        dest.writeString(crew);
        dest.writeString(passengers);
        dest.writeString(capacity);
        dest.writeString(consumables);
    }
}
