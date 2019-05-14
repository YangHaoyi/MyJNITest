/**
 * @author : YangHaoYi on  2019/4/2610:40.
 * Email  :  yang.haoyi@qq.com
 * Description :车速服务
 * Change : YangHaoYi on  2019/4/2610:40.
 * Version : V 1.0
 */
#include "hyapi_car_speed_service.h"

/** 获取单例 */
HyApi::CarSpeedService* HyApi::CarSpeedService::getInstance() {
    static CarSpeedService instance;
    return &instance;
}

/** 设置车速 */
void HyApi::CarSpeedService::setSpeedUnit(HyApi::SpeedUnit unit) {
    speedUnit = unit;
}

/** 获取车速 */
HyApi::SpeedUnit HyApi::CarSpeedService::getSpeedUnit() {
    return speedUnit;
}

