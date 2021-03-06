// vue.config.js
module.exports = {
    // https://cli.vuejs.org/config/#devserver-proxy
    devServer: {
        port: 3000,
        proxy: {
            '/api': {
                target: 'http://localhost:8080/api/v1/student',
                ws: true,
                changeOrigin: true
            }
        }
    }
}