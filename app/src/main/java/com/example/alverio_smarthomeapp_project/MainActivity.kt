import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var deviceAdapter: DeviceAdapter
    private lateinit var deviceList: RecyclerView
    private lateinit var addDeviceButton: FloatingActionButton
    private lateinit var bottomNavView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        deviceList = findViewById(R.id.deviceList)
        addDeviceButton = findViewById(R.id.addDeviceButton)
        bottomNavView = findViewById(R.id.bottomNavView)

        // Set up RecyclerView
        deviceAdapter = DeviceAdapter(getDevices())
        deviceList.adapter = deviceAdapter
        deviceList.layoutManager = LinearLayoutManager(this)

        // Set up click listeners
        addDeviceButton.setOnClickListener {
            // TODO: Implement add device functionality
        }

        bottomNavView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    // Already on home, do nothing
                    true
                }
                R.id.nav_devices -> {
                    // TODO: Navigate to devices list
                    true
                }
                R.id.nav_profile -> {
                    // TODO: Navigate to profile
                    true
                }
                R.id.nav_settings -> {
                    // TODO: Navigate to settings
                    true
                }
                else -> false
            }
        }
    }

    private fun getDevices(): List<Device> {
        // TODO: Replace with actual device data from your smart home system
        return listOf(
            Device("1", "Living Room Lights", "Light", "On", true),
            Device("2", "Kitchen Thermostat", "Thermostat", "72°F", true),
            Device("3", "Front Door Lock", "Lock", "Locked", true),
            Device("4", "Bedroom TV", "TV", "Off", false)
        )
    }
}