import { NativeModules, Platform } from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-cache-sweeper' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

const CacheSweeper = NativeModules.CacheSweeper
  ? NativeModules.CacheSweeper
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

export function clearCache(): Promise<void> {
  return CacheSweeper.clearCache();
}
