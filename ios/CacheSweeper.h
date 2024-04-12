
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNCacheSweeperSpec.h"

@interface CacheSweeper : NSObject <NativeCacheSweeperSpec>
#else
#import <React/RCTBridgeModule.h>

@interface CacheSweeper : NSObject <RCTBridgeModule>
#endif

@end
