/** @type {import('next').NextConfig} */

const nextConfig = {
    target: 'server',
    output: "standalone",
    env: {
        API_HOST_URL: process.env.API_HOST_URL
    },
}

module.exports = nextConfig
