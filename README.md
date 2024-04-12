# react-native-cache-sweeper

`react-native-cache-sweeper` is a React Native module designed for Android applications to help clear the application cache directly from React Native code. This module provides an API to clear cache files.

## Installation

Install the module using npm:

```sh
npm install react-native-cache-sweeper
```
or using yarn
```sh
yarn add react-native-cache-sweeper
```

## Usage
To use this module, import it and call the provided methods as follows:

```js
import { clearCache } from 'react-native-cache-sweeper';

// Clear the app cache
clearCache();
```

## API
### clearCache()
Clears the application cache.

### Returns 
Promise<void>: A promise that resolves if the cache was successfully cleared, or rejects with an error.

## Example

```js
import React from 'react';
import { Button, View } from 'react-native';
import { clearCache } from 'react-native-cache-sweeper';

const App = () => {
  const handleClearCache = () => {
    clearCache().then(() => {
      alert('Cache cleared successfully!');
    }).catch((error) => {
      alert('Failed to clear cache: ' + error.message);
    });
  };

  return (
    <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
      <Button title="Clear Cache" onPress={handleClearCache} />
    </View>
  );
};

export default App;

```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
