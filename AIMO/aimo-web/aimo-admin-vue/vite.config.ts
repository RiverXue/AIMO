import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// ✅ 必须引入这两个
import { fileURLToPath, URL } from 'node:url'

export default defineConfig({
  plugins: [vue()],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))  // 正确使用别名
    }
  },
  // server: {
  // host: '127.0.0.1',  // 使用 IPv4，避免 ::1 报错
  //     port: 5173,         // 端口可改，避免冲突
  //     open: true          // 可选，启动后自动打开浏览器
  // }
}
)
