import * as React from 'react';

import { StyleSheet, View, Text, Button } from 'react-native';
import { clearCache } from 'react-native-cache-sweeper';

export default function App() {

  const handleClearCache = () => {
    console.log('Clearing cache ')
    clearCache();
  };

  return (
    <View style={styles.container}>
      <Button title="Clear Cache" onPress={() => handleClearCache()} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
