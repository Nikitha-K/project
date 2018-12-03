from django.conf.urls import include, url

from . import views


urlpatterns = [
    url(r'^$', views.home1, name="home1"),
    url(r'^home/$', views.home, name = 'home'),
    url(r'^boards/(?P<id>([0-9a-f]{24}))/$',views.Board_Topics,name="Board_Topic"),
    url(r'^boards/(?P<id>([0-9a-f]{24}))/new/$',views.new_topic,name="new_topic"),
]

