/**
 * @author : YangHaoYi on  2019/4/2610:40.
 * Email  :  yang.haoyi@qq.com
 * Description :车速服务
 * Change : YangHaoYi on  2019/4/2610:40.
 * Version : V 1.0
 */
#ifndef MYJNITEST_HYAPI_CAR_SPEED_H
#define MYJNITEST_HYAPI_CAR_SPEED_H


namespace HyApi{

typedef enum SpeedUnit
{
  METRE,
  KILOMETRE
} SpeedUnit;

#define CARSPEED_SERVICE() HyApi::CarSpeedService::getInstance()



    class CarSpeedService{

    public:
        static CarSpeedService* getInstance();
     /**
    @brief			设置车速单位
    @author			YangHaoyi
    @date			2019.5.13
    @param [in]		SpeedUnit speedUnit 	车速单位
    @return			void
    */
        void setSpeedUnit(SpeedUnit speedUnit);
    /**
    @brief			获取当前车速单位
    @author			YangHaoyi
    @date			2019.5.13
    @return			SpeedUnit speedUnit 	车速单位
    */
        SpeedUnit getSpeedUnit();
    private:
        SpeedUnit speedUnit;

    };
}


#endif //MYJNITEST_HYAPI_CAR_SPEED_H