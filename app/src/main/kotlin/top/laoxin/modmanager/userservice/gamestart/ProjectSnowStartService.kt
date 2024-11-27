package top.laoxin.modmanager.userservice.gamestart

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import top.laoxin.modmanager.R
import top.laoxin.modmanager.bean.GameInfoBean
import top.laoxin.modmanager.tools.ModTools
import top.laoxin.modmanager.tools.specialGameTools.ProjectSnowTools

class ProjectSnowStartService : Service() {
    companion object {
        const val TAG = "ProjectSnowStartService"
    }

    private val serviceScope = CoroutineScope(Dispatchers.IO + Job())
    // 添加一个无参数的构造函数
    // 声明一个 GameInfo 变量


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val gameInfo: GameInfoBean = if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.TIRAMISU) {
            @Suppress("DEPRECATION")
            intent?.extras?.getParcelable("game_info")!!
        } else {
            intent?.extras?.getParcelable("game_info", GameInfoBean::class.java)!!
        }

        val checkFilepath =
            "${ModTools.ROOT_PATH}/Android/data/${gameInfo.packageName}/files/${ProjectSnowTools.CHECK_FILENAME}"
        Log.d("TestService", "onStartCommand: $checkFilepath")

        // 显示通知
        val channelId = getString(R.string.channel_id)
        val channelName = getString(R.string.channel_name)
        val importance = NotificationManager.IMPORTANCE_HIGH
        val channel = NotificationChannel(channelId, channelName, importance)

        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)

        val notification: Notification = Notification.Builder(this, channelId)
            .setContentTitle(getString(R.string.channel_title))
            .setContentText(getString(R.string.channel_content))
            .setSmallIcon(R.drawable.app_icon)
            .setCategory(NotificationCompat.CATEGORY_CALL)
            .setOngoing(true)
            .build()

        startForeground(1, notification)

        serviceScope.launch {

            if (ProjectSnowTools.specialOperationStartGame(gameInfo)) {
                stopService()
            }

        }
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        serviceScope.cancel()
    }

    fun stopService() {
        Log.d(TAG, "stopService: 服务已关闭")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            stopForeground(STOP_FOREGROUND_REMOVE)
            stopForeground(STOP_FOREGROUND_DETACH)
        } else {
            @Suppress("DEPRECATION")
            stopForeground(true)
        }
        stopSelf()
    }

}