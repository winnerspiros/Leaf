package org.dreeam.leaf.config.modules.opt;

import org.dreeam.leaf.config.ConfigCategory;
import org.dreeam.leaf.config.ConfigModule;

public class OptimizeSuffocation extends ConfigModule {

    public String basePath() {
        return ConfigCategory.PERF.basePath() + ".optimize-suffocation";
    }

    public static boolean enableSuffocationOptimization = true;

    @Override
    public void onLoaded() {
        enableSuffocationOptimization = globalConfig.getBoolean(basePath() + ".enabled", enableSuffocationOptimization,
            globalConfig.pickStringRegionBased(
                """
                    Only check wall suffocation every 10 ticks when the entity cannot be hurt anyway.""",
                """
                    仅在实体可能受伤时才检查墙内窒息。"""));
    }
}
