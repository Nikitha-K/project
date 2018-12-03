from django.conf.urls import  url
from . import views
urlpatterns = [
    url(r'^$',views.home,name="home"),
    url(r'^AddEmployee/$', views.addemployee, name="addemployee"),
    url(r'^viewall/$',views.viewall,name="viewall"),
    url(r'^delete/(?P<emp_id>([0-9a-f]{24}))/$',views.delete,name="delete"),
    url(r'^update/(?P<emp_id>([0-9a-f]{24}))/$',views.update.as_view(),name="update"),
    url(r'^uploaddata/$',views.uploaddata,name="uploaddata"),
    url(r'^search/$',views.search,name="search"),
    url(r'^upload/$', views.upload, name="upload"),
    url(r'^download/$', views.download, name="download"),

]