# AIMO Admin Vue

This directory contains the frontend application for the AIMO admin panel, built with Vue.js and Element Plus.

## Project Structure

- `src`: Source code for the Vue.js application.
- `public`: Static assets.
- `package.json`: Project dependencies and scripts.

## Getting Started

### Prerequisites

- Node.js (LTS version recommended)
- npm or Yarn

### Setup

1.  **Navigate to the project directory:**

    ```bash
    cd aimo-web/aimo-admin-vue
    ```

2.  **Install dependencies:**

    ```bash
    npm install
    # or yarn install
    ```

3.  **Run the development server:**

    ```bash
    npm run serve
    # or yarn serve
    ```

    The application will typically be available at `http://localhost:8080` (or another port if 8080 is in use).

### Build for Production

```bash
npm run build
# or yarn build
```

This will compile and minify the application into the `dist` directory for deployment.

## Configuration

Frontend configurations, such as API endpoint URLs, will be managed within the `src` directory (e.g., in environment variables or a configuration file).

## Contributing

Refer to the main project `README.md` for general contribution guidelines.